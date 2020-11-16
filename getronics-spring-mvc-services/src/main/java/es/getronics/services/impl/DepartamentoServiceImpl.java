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
import es.getronics.exceptions.EmpleadosExistentes;
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
	private TecnologiasDao tecnologiasDao;

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
		entity.setTecnologia(obtenerTecnologias(dto.getTecnologiasLista()));
		dto = modelMapper.map(departamentoDao.insert(entity), DepartamentoDto.class);
		return dto;
	}
	
	// posible chapuza, investigar un metodo mejor de hacerlo ... 
	public List<Tecnologias> obtenerTecnologias(Long[] ids){
		List<Tecnologias> lista = new ArrayList<>();
		for(Long id : ids) {
			lista.add(tecnologiasDao.findById(id));
		}
		return lista;
		
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
	public void comprobarEmpleados(Long idDepart) throws EmpleadosExistentes {
		Departamento departamento = departamentoDao.findById(idDepart);
		if(departamento.getNombreEmpleado()!=null) {
			throw new EmpleadosExistentes("Error al eliminar, el departamento posee empleados");
		}
	}

	@Override
	public void comprobarNombreDepartamento(String nombre) throws DepartamentoExistenteException {
		Departamento example = new Departamento();
		example.setNombre(nombre);
		if(!departamentoDao.findByExample(example).isEmpty())
			throw new DepartamentoExistenteException("El nombre del departamento ya existe.");
	}

	public List<Tecnologias> obtenerTecnologiasDepartamento(Long idDepartamento){
		return departamentoDao.findById(idDepartamento).getTecnologia();
	}
	
	@Override
	public void eliminarTecnologia(Long idTecnologia, Long idDepartamento) {
		Departamento entity = departamentoDao.findById(idDepartamento);
		List<Tecnologias> tecnologias = entity.getTecnologia();
		for(int i=0; i<tecnologias.size(); i++) {
			if(tecnologias.get(i).getId().equals(idTecnologia)) {
				tecnologias.remove(i);
			}
		}
		entity.setTecnologia(tecnologias);
		departamentoDao.update(entity);
	}
}
