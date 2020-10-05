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

import es.getronics.bom.Empleado;
import es.getronics.dao.EmpleadoDao;
import es.getronics.dto.EmpleadoDto;
import es.getronics.services.EmpleadoService;

/**
 * Implementa la logica del servicio de empleados
 * 
 * @author jgarcia
 *
 */
@Service("empleadoService")
public class EmpleadoServiceImpl implements EmpleadoService {

	@Autowired
	EmpleadoDao empleadoDao;
	
	@Autowired
	private ModelMapper modelMapper;
		
	public EmpleadoServiceImpl() {
		super();
	}

	@Override
	public EmpleadoDto findById(Long id) {
		Empleado entity = empleadoDao.findById(id);
		return modelMapper.map(entity, EmpleadoDto.class);
	}

	@Override
	public List<EmpleadoDto> findAll() {
		List<EmpleadoDto> result = new ArrayList<>();
		List<Empleado> found = empleadoDao.findAll();
		for(Empleado empleado: found) {
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
		Empleado entity = modelMapper.map(dto, Empleado.class);
		empleadoDao.update(entity);
	}

	@Override
	public void saveOrUpdate(EmpleadoDto entity) {
		throw new NotYetImplementedException("Método no implementado todavía");
	}

	@Override
	public EmpleadoDto insert(EmpleadoDto dto) {
		Empleado entity = modelMapper.map(dto, Empleado.class);
		dto = modelMapper.map(empleadoDao.insert(entity), EmpleadoDto.class);
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
}
