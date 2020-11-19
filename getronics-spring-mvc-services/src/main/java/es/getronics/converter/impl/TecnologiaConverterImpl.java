/**
 * @file TecnologiaConverterImpl.java
 * @date 19 nov. 2020
 * @time 13:52:46
 * 
 */
package es.getronics.converter.impl;

import es.getronics.bom.Tecnologia;
import es.getronics.converter.Converter;
import es.getronics.dto.KeyValueItem;
import es.getronics.dto.TecnologiaDto;
import es.getronics.dto.TecnologiaItem;

/**
 * @author alatorre
 *
 * 
 */
public class TecnologiaConverterImpl implements Converter<Tecnologia,TecnologiaDto>{

	@Override
	public TecnologiaDto convert(Tecnologia source) {
		TecnologiaDto result = new TecnologiaDto();
		result.setId(source.getId());
		result.setNombre(source.getNombre());
		result.setDescripcion(source.getDescripcion());
		return result;
	}

	@Override
	public Tecnologia map(TecnologiaDto source) {
		Tecnologia result = new Tecnologia();
		result.setId(source.getId());
		result.setNombre(source.getNombre());
		result.setDescripcion(source.getDescripcion());
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
