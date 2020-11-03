package es.getronics.converter;

import org.springframework.beans.factory.annotation.Autowired;

import es.getronics.bom.Tecnologia;
import es.getronics.dto.TecnologiaDto;
import es.getronics.services.TecnologiaService;

public class TecnoConverter implements Converter<String,TecnologiaDto> {

	@Autowired
	TecnologiaService tecnologiaService;
	
	
	@Override
	public TecnologiaDto convert(String source) {
		return tecnologiaService.findById(Long.parseLong(source));
	}

	@Override
	public String map(TecnologiaDto dto) {
		// TODO Auto-generated method stub
		return null;
	}




}
