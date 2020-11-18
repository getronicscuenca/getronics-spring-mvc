package es.getronics.services;

import es.getronics.base.services.GenericService;
import es.getronics.bom.Empleado;
import es.getronics.dto.DepartamentoDto;
import es.getronics.dto.EmpleadoDto;
import es.getronics.dto.TecnologiaDto;
import es.getronics.exceptions.ExcepcionDepartamento;
import es.getronics.exceptions.ExcepcionEmpleado;

/**
 * Define las operaciones de negocio de alumnos
 * 
 * @author smartinez
 */
public interface EmpleadoService extends GenericService<EmpleadoDto, Empleado, Empleado, TecnologiaDto, Long> {
	//String findByName(EmpleadoDto empleado);
	EmpleadoDto insert(EmpleadoDto dto) throws ExcepcionEmpleado;
	void remove(Long id) throws ExcepcionEmpleado;
}
