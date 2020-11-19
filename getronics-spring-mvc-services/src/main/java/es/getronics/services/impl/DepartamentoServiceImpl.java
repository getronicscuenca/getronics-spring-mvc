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
import es.getronics.converter.Converter;
import es.getronics.dao.DepartamentoDao;
import es.getronics.dao.EmpleadoDao;
import es.getronics.dto.DepartamentoDto;
import es.getronics.dto.TecnologiasDto;
import es.getronics.exceptions.DepartamentoExistenteException;
import es.getronics.services.DepartamentoService;
import es.getronics.services.EmpleadoService;

@Service("departamentoService")
public class DepartamentoServiceImpl implements DepartamentoService {

	@Autowired
	private Converter<Departamento, DepartamentoDto> departamentoConverter;

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
		return departamentoConverter.convert(departamentoDao.findById(id));

	}

	@Override
	public List<DepartamentoDto> findAll() {
		List<DepartamentoDto> result = new ArrayList<>();
		List<Departamento> found = departamentoDao.findAll();
		for (Departamento departamento : found) {
			result.add(departamentoConverter.convert(departamento));
		}
		return result;
	}

	@Override
	public List<DepartamentoDto> findAllOrderBy(String[] orderBy, boolean asc) {
		throw new NotYetImplementedException("metodo no implementado todavia");
	}

	@Override
	public void update(DepartamentoDto dto) {
		Departamento entity = departamentoConverter.map(dto);
		departamentoDao.update(entity);

	}

	@Override
	public void saveOrUpdate(DepartamentoDto entity) {
		throw new NotYetImplementedException("metodo no implementado todavia");

	}

	@Override
	public DepartamentoDto insert(DepartamentoDto dto) {
		Departamento entity = departamentoConverter.map(dto);
		dto= departamentoConverter.convert(departamentoDao.insert(entity));
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
	public List<DepartamentoDto> findByName(DepartamentoDto departamentoDto) {
		Departamento example = new Departamento();
		example.setNombre(departamentoDto.getNombre());
		List<DepartamentoDto> result = new ArrayList<>();
		for (Departamento departamento : departamentoDao.findByExample(example)) {
			result.add(departamentoConverter.convert(departamento));
		}
		return result;
	}
	
	public List<Departamento> buscarName(DepartamentoDto dto){
		return departamentoDao.findByName(dto.getNombre());
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
		} else if (primerDepartamento(departamento) == false && findByName(departamento).isEmpty()
				&& empleadoAsignado(departamento) == false) {
			departamento.setAlta(new Date());
			departamento.setNombreEmpleado(empleadoService.findById(departamento.getIdEmpleado()).getNombre());
			insert(departamento);
		} else {
			if (findByName(departamento).isEmpty() == false) {
				throw new DepartamentoExistenteException(
						"El departamento " + "'" + departamento.getNombre() + "'" + " ya existe.");
			} else if (empleadoAsignado(departamento) == true) {
				throw new DepartamentoExistenteException(
						"El empleado " + "'" + empleadoService.findById(departamento.getIdEmpleado()).getNombre() + "'"
								+ " ya tiene un departamento asignado.");
			}

		}

	}

	@Override
	public List<TecnologiasDto> recogerTecnologiasRelacionadas(Long id) {
		List <Tecnologias> tecnologias= departamentoDao.findById(id).getTecnologia();
		List<TecnologiasDto> result = new ArrayList<>();
		for (Tecnologias tecnologia : tecnologias) {
			result.add(modelMapper.map(tecnologia, TecnologiasDto.class));
		}
		return result;
	}

	@Override
	public void borrarTecnologia(Long idTecnologia, Long idDepartamento) {
		Departamento entity= departamentoDao.findById(idDepartamento);
		List <Tecnologias> tecnologias= entity.getTecnologia();
		   for(int i=0; i<tecnologias.size(); i++) {
	            if(tecnologias.get(i).getId().equals(idTecnologia)) {
	                tecnologias.remove(i);
	            }
	        }
	        entity.setTecnologia(tecnologias);
	        departamentoDao.update(entity);
		
	}

}
