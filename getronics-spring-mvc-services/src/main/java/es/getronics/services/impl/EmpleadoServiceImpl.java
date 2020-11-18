/**
 * 
 */
package es.getronics.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.cfg.NotYetImplementedException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.getronics.bom.Departamento;
import es.getronics.bom.Empleado;
import es.getronics.converter.Converter;
import es.getronics.converter.EmpleadoConverter;
import es.getronics.converter.impl.EmpleadoConverterImpl;
//import es.getronics.converter.EmpleadoConverterImpl;
import es.getronics.dao.DepartamentoDao;
import es.getronics.dao.EmpleadoDao;
import es.getronics.dao.impl.DepartamentoDaoImpl;
import es.getronics.dto.DepartamentoDto;
import es.getronics.dto.EmpleadoDto;
import es.getronics.dto.TecnologiaDto;
import es.getronics.exceptions.ExcepcionDepartamento;
import es.getronics.exceptions.ExcepcionEmpleado;
import es.getronics.services.EmpleadoService;
import es.getronics.services.DepartamentoService;
import es.getronics.services.impl.DepartamentoServiceImpl;

/**
 * Implementa la logica del servicio de empleados
 *
 * @author smartinez
 *
 */
@Service("empleadoService")
public class EmpleadoServiceImpl implements EmpleadoService {
	//FALTA EL FINDBYNAME, QUIZAS LO NECESITEMOS
	//EN EL FINAL ESTAN LOS NUEVOS OVERRIDES

	@Autowired
	EmpleadoDao empleadoDao;
	
	@Autowired
	private DepartamentoDao departamentoDao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	//@Autowired(required=true)
	//private EmpleadoConverter<EmpleadoDto, Empleado> empleadoConverter;
		
		
	public EmpleadoServiceImpl() {
		super();
	}

	@Override
	public EmpleadoDto findById(Long id) {
		Empleado entity = empleadoDao.findById(id);
		//return empleadoConverter.convert(entity);
		return modelMapper.map(entity, EmpleadoDto.class);
	}

	@Override
	public List<EmpleadoDto> findAll() {
		List<EmpleadoDto> result = new ArrayList<>();
		List<Empleado> found = empleadoDao.findAll();
		for(Empleado empleado: found) {
			//result.add(empleadoConverter.convert(empleado));
			result.add(modelMapper.map(empleado, EmpleadoDto.class));
		}
		return result;
	}

	@Override
	public List<EmpleadoDto> findAllOrderBy(String[] orderBy, boolean asc) {
		throw new NotYetImplementedException("Método no implementado todavía");
	}

	@Override
	public void update(EmpleadoDto dto) {
		//Empleado entity = empleadoConverter.map(dto);
		Empleado entity = modelMapper.map(dto, Empleado.class);
		empleadoDao.update(entity);
	}

	@Override
	public void saveOrUpdate(EmpleadoDto entity) {
		throw new NotYetImplementedException("Método no implementado todavía");
	}

	@Override
	public EmpleadoDto insert(EmpleadoDto dto) throws ExcepcionEmpleado{
		//Empleado entity = empleadoConverter.map(dto);
		Empleado entity = modelMapper.map(dto, Empleado.class);
		
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
					//dto = empleadoConverter.convert(empleadoDao.insert(entity));
					dto= modelMapper.map(empleadoDao.insert(entity), EmpleadoDto.class);
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
		/*if (dto.getJefe()!=null){
			throw new ExcepcionEmpleado("No se puede eliminar el empleado porque es un jefe");
		}
		else {*/
		empleadoDao.remove(id);
		//}
	}

	@Override
	public void remove(EmpleadoDto entity) {
		throw new NotYetImplementedException("Método no implementado todavía");
	}

	@Override
	public List<EmpleadoDto> findByExample(EmpleadoDto example) {
		throw new NotYetImplementedException("Método no implementado todavía");
	}
	
	//FINAL METODOS OVERRIDES
	@Override
	public List<Empleado> T3findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateT3(Empleado entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Empleado insertT3(Empleado entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmpleadoDto nuevaTecnoDepartamento(TecnologiaDto entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Long> convertToListId(Set<EmpleadoDto> source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<EmpleadoDto> mapToListId(Set<Long> dto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
}
