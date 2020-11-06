package es.getronics.converter;

import org.springframework.stereotype.Component;

import es.getronics.bom.Tecnologias;
import es.getronics.dto.TecnologiasDto;

@Component
public class TecnologiasConverter implements Converter <Tecnologias, TecnologiasDto> {

	@Override
	public TecnologiasDto convert(Tecnologias source) {
		TecnologiasDto result= new TecnologiasDto();
		result.setId(source.getId());
		result.setNombre(source.getNombre());
		result.setDescripcion(source.getDescripcion());
		return result;
	}

	@Override
	public Tecnologias map(TecnologiasDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
