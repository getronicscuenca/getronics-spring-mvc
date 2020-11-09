package es.getronics.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.cfg.NotYetImplementedException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.getronics.bom.Departamento;
import es.getronics.bom.Empleado;
import es.getronics.converter.Converter;
import es.getronics.converter.DepartamentoConverter;
import es.getronics.converter.EmpleadoConverter;
import es.getronics.dao.DepartamentoDao;
import es.getronics.dao.EmpleadoDao;
import es.getronics.dto.DepartamentoDto;
import es.getronics.dto.EmpleadoDto;
import es.getronics.services.DepartamentoService;
import es.getronics.exceptions.ExcepcionDepartamento;


@Service("departamentoService")
public class DepartamentoServiceImpl implements DepartamentoService{

	
	@Autowired
	DepartamentoDao departamentoDao;
	
	@Autowired
	EmpleadoDao empleadoDao;
		
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private Converter<Empleado, EmpleadoDto> empleadoConverter;
	
	@Autowired
	private Converter<Departamento, DepartamentoDto> departamentoConverter;
	
	public DepartamentoServiceImpl()
	{
		super();
	}
	
	@Override
	public DepartamentoDto findById(Long id){
		Departamento entity = departamentoDao.findById(id);
		return modelMapper.map(entity, DepartamentoDto.class);
		
	}

	@Override
	public List<DepartamentoDto> findAll() {
		List<DepartamentoDto> result = new ArrayList<>();
		List<Departamento> found= departamentoDao.findAll();
		for(Departamento departamento: found)
		{
			result.add(modelMapper.map(departamento, DepartamentoDto.class));
		}
		return result;
	}
	
	
	@Override
	public List<EmpleadoDto> findAllT3(DepartamentoDto departamentoDto) {
		List<EmpleadoDto> result = new ArrayList<>();
		Departamento departamento=modelMapper.map(departamentoDto, Departamento.class);
		//List<Departamento> found= departamentoDao.findAll();
		for(Empleado empleado: departamento.getEmpleados())
		{
			result.add(modelMapper.map(empleado, EmpleadoDto.class));
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
	public DepartamentoDto insert(DepartamentoDto dto) throws ExcepcionDepartamento {
		Departamento entity = modelMapper.map(dto, Departamento.class);
		//Departamento entity = departamentoConverter.map(dto);
				
		Boolean departamentoExiste=false;
				
		for(Departamento departamento:departamentoDao.findAll()) {
			if(departamento.getNombre().equals(dto.getNombre())) {
				departamentoExiste=true;
			}
		}
		if(departamentoExiste) {
			throw new ExcepcionDepartamento("El departamento ya existe");
		}
		else { 
			/*if(dto.getJefe()==null) {
				throw new ExcepcionDepartamento("El departamento tiene que tener un jefe");
			}
			else
				if (entity.getEmpleados()==null){
					throw new ExcepcionDepartamento("El departamento tiene que tener al menos un empleado");
				}
				else {*/
			
					dto= modelMapper.map(departamentoDao.insert(entity), DepartamentoDto.class);
					//dto = departamentoConverter.convert(departamentoDao.insert(entity));
					
				}
		return dto;
	}
	
	//INSERTAR UN NUEVO EMPLEADO EN UN DEPARTAMENTO
	public DepartamentoDto nuevoEmpleDepartamento(EmpleadoDto dto) {
		Departamento departamento= departamentoDao.findById(dto.getIdDepartamento());
		departamento.getEmpleados().add(empleadoConverter.map(dto));
		DepartamentoDto departamentoDto = modelMapper.map(departamento, DepartamentoDto.class);
		return departamentoDto;
	}
	//QUITAR UN EMPLEADO DE UN DEPARTAMENTO
	public DepartamentoDto eliminarEmpleDepartamento(Long id) {
		Empleado empleado= empleadoDao.findById(id);
		Departamento departamento= departamentoDao.findById(empleado.getDepartamento().getId());
		departamento.getEmpleados().remove(empleado);
		DepartamentoDto departamentoDto = modelMapper.map(departamento, DepartamentoDto.class);
		return departamentoDto;
	}

	@Override
	public void remove(DepartamentoDto entity) {
		throw new NotYetImplementedException("metodo no implementado todavia");
	}

	@Override
	public void remove(Long id) throws ExcepcionDepartamento {
		DepartamentoDto dto = modelMapper.map(departamentoDao.findById(id), DepartamentoDto.class);
		if (!dto.getEmpleados().isEmpty()){
			throw new ExcepcionDepartamento("No se puede eliminar el departamento porque tiene empleados");
		}
		else {
		departamentoDao.remove(id);
		}
		
	}

	@Override
	public List<DepartamentoDto> findByExample(DepartamentoDto example) {
		throw new NotYetImplementedException("metodo no implementado todavia");
	}
	
	@Override
	public String findByName(DepartamentoDto departamento){
		List<Departamento> lista =departamentoDao.findAll();
		for(Departamento dep:lista) {
			if(dep.getNombre().equals(departamento.getNombre())) {
				return dep.getNombre();
			}
		}
		return "";
		
	}
	
}
