package es.getronics.converter.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.getronics.bom.Departamento;
import es.getronics.bom.Tecnologias;
import es.getronics.converter.Converter;
import es.getronics.dao.DepartamentoDao;
import es.getronics.dto.TecnologiasDto;

@Component("tecnologiasConverter")
public class TecnologiasConverterImpl implements Converter <Tecnologias, TecnologiasDto> {

	
	
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
		Tecnologias entity= new Tecnologias();
		entity.setId(dto.getId());
		entity.setNombre(dto.getNombre());
		entity.setDescripcion(dto.getDescripcion());
		return entity;
	}

}
