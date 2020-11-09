/**
 * 
 */
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
import es.getronics.converter.EmpleadoConverter;
import es.getronics.dao.DepartamentoDao;
import es.getronics.dao.EmpleadoDao;
import es.getronics.dao.impl.DepartamentoDaoImpl;
import es.getronics.dto.DepartamentoDto;
import es.getronics.dto.EmpleadoDto;
import es.getronics.exceptions.ExcepcionDepartamento;
import es.getronics.exceptions.ExcepcionEmpleado;
import es.getronics.services.EmpleadoService;
import es.getronics.services.DepartamentoService;
import es.getronics.services.impl.DepartamentoServiceImpl;

/**
 * Implementa la logica del servicio de empleados
 *
 * @author jgarcia
 *
 */
@Service("empleadoService")
public class EmpleadoServiceImpl implements EmpleadoService {
	//FALTA EL FINDBYNAME, QUIZAS LO NECESITEMOS

	@Autowired
	EmpleadoDao empleadoDao;
	
	@Autowired
	private DepartamentoDao departamentoDao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private Converter<Empleado, EmpleadoDto> empleadoConverter;
		
		
	@Override
	public List<Empleado> findAllT3(EmpleadoDto tipo1) {
		// TODO Auto-generated method stub
		return null;
	}

	public EmpleadoServiceImpl() {
		super();
	}

	@Override
	public EmpleadoDto findById(Long id) {
		Empleado entity = empleadoDao.findById(id);
		return empleadoConverter.convert(entity);
	}

	@Override
	public List<EmpleadoDto> findAll() {
		List<EmpleadoDto> result = new ArrayList<>();
		List<Empleado> found = empleadoDao.findAll();
		for(Empleado empleado: found) {
			result.add(empleadoConverter.convert(empleado));
		}
		return result;
	}

	@Override
	public List<EmpleadoDto> findAllOrderBy(String[] orderBy, boolean asc) {
		throw new NotYetImplementedException("Método no implementado todavía");
	}

	@Override
	public void update(EmpleadoDto dto) {
		Empleado entity = empleadoConverter.map(dto);
		empleadoDao.update(entity);
	}

	@Override
	public void saveOrUpdate(EmpleadoDto entity) {
		throw new NotYetImplementedException("Método no implementado todavía");
	}

	@Override
	public EmpleadoDto insert(EmpleadoDto dto) throws ExcepcionEmpleado{
		Empleado entity = empleadoConverter.map(dto);
		
		Boolean empleadoExiste=false;
		
		for(Empleado empleado:empleadoDao.findAll()) {
			if(empleado.getNombre().equals(dto.getNombre()) &&
				empleado.getApellido1().equals(dto.getApellido1()) && 
				empleado.getApellido2().equals(dto.getApellido2())) {
				empleadoExiste=true;
			}
		}
		if(empleadoExiste) {
			throw new ExcepcionEmpleado("El empleado ya existe");
		}
		else
			if(dto.getIdDepartamento()== null) {
				throw new ExcepcionEmpleado("El empleado tiene que pertenecer a un departamento");
			}
			else 
				{	/*if(dto.getJefe() == null) {
					throw new ExcepcionEmpleado("El empleado tiene que tener un jefe");
				}
				else {*/
					dto = empleadoConverter.convert(empleadoDao.insert(entity));
				}
		return dto;
	}
	
	public EmpleadoDto nuevoEmpleDepartamento(Empleado entity) {
		EmpleadoDto empleado=null;
		return empleado;
	}
	
	public EmpleadoDto eliminarEmpleDepartamento(Long id) {
		EmpleadoDto empleado=null;
		return empleado;
	}
	
	@Override
	public void remove(Long id) throws ExcepcionEmpleado {
		EmpleadoDto dto = modelMapper.map(empleadoDao.findById(id), EmpleadoDto.class);
		if (dto.getJefe()!=null){
			throw new ExcepcionEmpleado("No se puede eliminar el empleado porque es un jefe");
		}
		else {
		empleadoDao.remove(id);
		}
	}

	@Override
	public void remove(EmpleadoDto entity) {
		throw new NotYetImplementedException("Método no implementado todavía");
	}

	@Override
	public List<EmpleadoDto> findByExample(EmpleadoDto example) {
		throw new NotYetImplementedException("Método no implementado todavía");
	}
	
}
