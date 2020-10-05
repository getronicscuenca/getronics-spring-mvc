/**
 * 
 */
package es.getronics.converter;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import es.getronics.bom.Empleado;
import es.getronics.dto.EmpleadoDto;

/**
 * Convierte de Entidad empleado a Dto
 * 
 * @author jgarcia
 *
 */
public class EmpleadoConverter implements Converter<Empleado, EmpleadoDto> {

	@Override
	public EmpleadoDto convert(MappingContext<Empleado, EmpleadoDto> context) {
		Empleado source = context.getSource();
		EmpleadoDto result = new EmpleadoDto();
		result.setId(source.getId());
		result.setNombre(source.getNombre());
		result.setApellido1(source.getApellido1());
		result.setApellido2(source.getApellido2());
		return result;
	}


}
