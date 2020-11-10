package es.getronics.converter;

import org.springframework.stereotype.Component;

import es.getronics.bom.Tecnologia;
import es.getronics.dto.TecnologiaDTO;

@Component
public class TecnologiaConverter implements Converter<Tecnologia, TecnologiaDTO> {

	@Override
	public TecnologiaDTO convert(Tecnologia source) {
		TecnologiaDTO dto = new TecnologiaDTO();
		dto.setId(source.getId());
		dto.setNombre(source.getNombre());
		dto.setDescripcion(source.getDescripcion());
		return dto;
	}

	@Override
	public Tecnologia map(TecnologiaDTO dto) {
		Tecnologia res = new Tecnologia();
		res.setId(dto.getId());
		res.setNombre(dto.getNombre());
		res.setDescripcion(dto.getDescripcion());
		return res;
	}

}
