package es.getronics.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.cfg.NotYetImplementedException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.getronics.bom.Departamento;
import es.getronics.bom.Empleado;
import es.getronics.bom.Tecnologias;
import es.getronics.dao.DepartamentoDao;
import es.getronics.dao.EmpleadoDao;
import es.getronics.dao.TecnologiasDao;
import es.getronics.dto.DepartamentoDto;
import es.getronics.dto.EmpleadoDto;
import es.getronics.exceptions.DepartamentoExistenteException;
import es.getronics.services.DepartamentoService;
import es.getronics.services.EmpleadoService;

@Service("departamentoService")
public class DepartamentoServiceImpl implements DepartamentoService {


	@Autowired
	private DepartamentoDao departamentoDao;

	@Autowired
	private EmpleadoDao empleadoDao;

	@Autowired
	private EmpleadoService empleadoService;

	@Autowired
	private ModelMapper modelMapper;

	public DepartamentoServiceImpl() {
		super();
	}

	@Override
	public DepartamentoDto findById(Long id) {
		Departamento entity = departamentoDao.findById(id);
		return modelMapper.map(entity, DepartamentoDto.class);

	}

	@Override
	public List<DepartamentoDto> findAll() {
		List<DepartamentoDto> result = new ArrayList<>();
		List<Departamento> found = departamentoDao.findAll();
		for (Departamento departamento : found) {
			result.add(modelMapper.map(departamento, DepartamentoDto.class));
		}
		return result;
	}

	@Override
	public List<DepartamentoDto> findAllOrderBy(String[] orderBy, boolean asc) {
		throw new NotYetImplementedException("metodo no implementado todavia");
	}

	@Override
	public void update(DepartamentoDto dto) {
		Departamento entity = modelMapper.map(dto, Departamento.class);
		departamentoDao.update(entity);

	}

	@Override
	public void saveOrUpdate(DepartamentoDto entity) {
		throw new NotYetImplementedException("metodo no implementado todavia");

	}

	@Override
	public DepartamentoDto insert(DepartamentoDto dto) {
		Departamento entity = modelMapper.map(dto, Departamento.class);
		dto = modelMapper.map(departamentoDao.insert(entity), DepartamentoDto.class);
		return dto;
	}

	@Override
	public void remove(DepartamentoDto entity) {
		throw new NotYetImplementedException("metodo no implementado todavia");

	}

	@Override
	public void remove(Long id) {
		departamentoDao.remove(id);
	}

	@Override
	public List<DepartamentoDto> findByExample(DepartamentoDto example) {
		throw new NotYetImplementedException("metodo no implementado todavia");
	}

	@Override
	public boolean findByName(DepartamentoDto departamentoDto) {
		Departamento example = new Departamento();
		example.setNombre(departamentoDto.getNombre());
		List<Departamento> entity = departamentoDao.findByExample(example);
		return entity.isEmpty();
	}

	@Override
	public boolean primerDepartamento(DepartamentoDto departamentoDto) {
		List<Departamento> entity = departamentoDao.findAll();
		List<Empleado> empleados = empleadoDao.findAll();
		if (entity.isEmpty() || empleados.isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean empleadoAsignado(DepartamentoDto dto) {
		List<Departamento> listaDepartamento = departamentoDao.findAll();
		for (Departamento departamento : listaDepartamento) {
			if(departamento.getIdEmpleado()!=null) {
				if (departamento.getIdEmpleado().equals(dto.getIdEmpleado())) {
					return true;
				}
			}			
		}
		return false;

	}

	@Override
	public void validarDepartamento(DepartamentoDto departamento) throws DepartamentoExistenteException {

		if (primerDepartamento(departamento) == true) {
			departamento.setAlta(new Date());
			departamento.setIdEmpleado(null);
			departamento.setNombreEmpleado("");
			insert(departamento);
		} else if (primerDepartamento(departamento) == false && findByName(departamento) == true
				&& empleadoAsignado(departamento) == false) {
			departamento.setAlta(new Date());
			departamento.setNombreEmpleado(empleadoService.findById(departamento.getIdEmpleado()).getNombre());
			insert(departamento);
		} else {
			if (findByName(departamento) == false) {
				throw new DepartamentoExistenteException(
						"El departamento " + "'" + departamento.getNombre() + "'" + " ya existe.");
			} else if (empleadoAsignado(departamento) == true) {
				throw new DepartamentoExistenteException(
						"El empleado " + "'" + empleadoService.findById(departamento.getIdEmpleado()).getNombre() + "'"
								+ " ya tiene un departamento asignado.");
			}

		}

	}

}
