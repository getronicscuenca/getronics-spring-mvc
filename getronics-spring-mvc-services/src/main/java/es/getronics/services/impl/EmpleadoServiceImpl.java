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

import es.getronics.bom.Empleado;
import es.getronics.converter.Converter;
import es.getronics.converter.impl.EmpleadoConverterImpl;
import es.getronics.dao.DepartamentoDao;
import es.getronics.dao.EmpleadoDao;
import es.getronics.dto.EmpleadoDto;
import es.getronics.dto.TecnologiaDto;
import es.getronics.exceptions.ExcepcionEmpleado;
import es.getronics.services.EmpleadoService;

/**
 * Implementa la logica del servicio de empleados
 *
 * @author smartinez
 *
 */
@Service("empleadoService")
public class EmpleadoServiceImpl implements EmpleadoService {

	@Autowired
	EmpleadoDao empleadoDao;
	
	@Autowired
	private DepartamentoDao departamentoDao;
	
	@Autowired
	private Converter<Empleado, EmpleadoDto> empleadoConverter;
		
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
		Empleado entity = empleadoDao.findById(dto.getId());
		entity.setNombre(dto.getNombre());
		entity.setApellido1(dto.getApellido1());
		entity.setApellido2(dto.getApellido2());
		if(dto.getIdDepartamento() != null) {
			entity.setDepartamento(departamentoDao.findById(dto.getIdDepartamento()));
		}
		empleadoDao.update(entity);
	}

	@Override
	public void saveOrUpdate(EmpleadoDto entity) {
		throw new NotYetImplementedException("Método no implementado todavía");
	}

	@Override
	public EmpleadoDto insert(EmpleadoDto dto) throws ExcepcionEmpleado {
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
	
	@Override
	public void remove(Long id) {
		empleadoDao.remove(id);
	}

	@Override
	public void remove(EmpleadoDto entity) {
		throw new NotYetImplementedException("Método no implementado todavía");
	}

	@Override
	public List<EmpleadoDto> findByExample(EmpleadoDto example) {
		throw new NotYetImplementedException("Método no implementado todavía");
	}

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
	public Set<Long> convertToListId(Set<EmpleadoDto> source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<EmpleadoDto> mapToListId(Set<Long> dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmpleadoDto nuevoEmpleDepartamento(Empleado entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmpleadoDto eliminarEmpleDepartamento(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmpleadoDto nuevaTecnoDepartamento(TecnologiaDto entity) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
