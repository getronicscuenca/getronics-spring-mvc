/**
 * 
 */
package es.getronics.converter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.getronics.bom.Empleado;
import es.getronics.bom.Tecnologia;
import es.getronics.converter.Converter;
import es.getronics.dao.DepartamentoDao;
import es.getronics.dto.EmpleadoDto;
import es.getronics.dto.TecnologiaDto;

/**
 * Convierte de Entidad empleado a Dto
 * 
 * @author jgarcia
 *
 */
@Component("tecnologiaConverter")
public class TecnologiaConverterImpl implements Converter<Tecnologia, TecnologiaDto> {

	@Override
	public TecnologiaDto convert(Tecnologia source) {
		TecnologiaDto result = new TecnologiaDto();
		result.setId(source.getId());
		result.setNombre(source.getNombre());
		result.setDescripcion(source.getDescripcion());
		
		return result;
	}

	@Override
	public Tecnologia map(TecnologiaDto dto) {
		Tecnologia result = new Tecnologia();
		result.setId(dto.getId());
		result.setNombre(dto.getNombre());
		result.setDescripcion(dto.getDescripcion());
		
		return result;
	}
}
