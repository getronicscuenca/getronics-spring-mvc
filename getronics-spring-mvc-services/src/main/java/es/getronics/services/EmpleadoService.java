package es.getronics.services;

import java.util.List;

import es.getronics.base.services.GenericService;
import es.getronics.bom.Empleado;
import es.getronics.dto.EmpleadoDto;

/**
 * Define las operaciones de negocio de alumnos
 * 
 * @author jgarcia
 */
public interface EmpleadoService extends GenericService<EmpleadoDto, Empleado, Long> {

	List<EmpleadoDto> findAll(long id);
	List<EmpleadoDto> findAll();

}
