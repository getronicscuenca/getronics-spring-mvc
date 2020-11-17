/**
 * 
 */
package es.getronics.converter.impl;

import org.springframework.stereotype.Component;

import es.getronics.bom.Tecnologia;
import es.getronics.converter.Converter;
import es.getronics.dto.KeyValueItem;
import es.getronics.dto.TecnologiaDto;
import es.getronics.dto.TecnologiaItem;

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

	@Override
	public KeyValueItem mapToKeyValue(Tecnologia source) {
		TecnologiaItem item = new TecnologiaItem();
		item.setKey(source.getId());
		item.setValue(source.getNombre());
		return item;
	}
}
