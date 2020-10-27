package es.getronics.converter;

import es.getronics.bom.Tecnologia;
import es.getronics.dto.TecnologiaDto;


public class TecnologiaConverter implements Converter<Tecnologia, TecnologiaDto>{

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
