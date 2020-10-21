/**
 * 
 */
package es.getronics.converter;

import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.getronics.bom.Empleado;
import es.getronics.dao.DepartamentoDao;
import es.getronics.dto.EmpleadoDto;

/**
 * Convierte de Entidad empleado a Dto
 * 
 * @author jgarcia
 *
 */
@Component
public class EmpleadoConverter implements Converter<Empleado, EmpleadoDto> {

	@Autowired
	private DepartamentoDao departamentoDao;
	
	@Override
	public EmpleadoDto convert(Empleado source) {
		EmpleadoDto result = new EmpleadoDto();
		result.setId(source.getId());
		result.setNombre(source.getNombre());
		result.setApellido1(source.getApellido1());
		result.setApellido2(source.getApellido2());
		result.setIdDepartamento(source.getDepartamento().getId());
		result.setDepartamento(source.getDepartamento().getNombre());
		return result;
	}

	@Override
	public Empleado map(EmpleadoDto dto) {
		Empleado result = new Empleado();
		result.setId(dto.getId());
		result.setNombre(dto.getNombre());
		result.setApellido1(dto.getApellido1());
		result.setApellido2(dto.getApellido2());
		result.setDepartamento(departamentoDao.findById(dto.getIdDepartamento()));
		return result;
	}


}
