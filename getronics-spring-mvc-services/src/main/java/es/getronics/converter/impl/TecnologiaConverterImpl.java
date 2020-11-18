package es.getronics.converter.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import es.getronics.bom.Departamento;
import es.getronics.bom.Tecnologia;
import es.getronics.converter.Converter;
import es.getronics.converter.DepartamentoConverter;
import es.getronics.converter.TecnologiaConverter;
import es.getronics.dao.DepartamentoDao;
import es.getronics.dao.TecnologiaDao;
import es.getronics.dto.DepartamentoDto;
import es.getronics.dto.TecnologiaDto;

public class TecnologiaConverterImpl implements Converter<Tecnologia, TecnologiaDto>, TecnologiaConverter<Tecnologia, TecnologiaDto> {

	@Autowired
	private DepartamentoDao departamentoDao;
	
	@Autowired
	private TecnologiaDao tecnologiaDao;
		
	@Autowired
	private DepartamentoConverter<Departamento, DepartamentoDto> departamentoConverter;
	
	@Override
	public TecnologiaDto convert(Tecnologia source) {
		TecnologiaDto result = new TecnologiaDto();
		result.setId(source.getId());
		result.setNombre(source.getNombre());
		result.setDesc(source.getDesc());
				
		return result;
	}

	@Override
	public Tecnologia map(TecnologiaDto dto) {
		Tecnologia result= new Tecnologia();
		result.setId(dto.getId());
		//result.setId(1L);
		result.setNombre(dto.getNombre());
		result.setDesc(dto.getDesc());
		
		return result;
	}

	@Override
	public TecnologiaDto convertToList(Tecnologia source) { 
		TecnologiaDto result = new TecnologiaDto();
		result.setId(source.getId());
		result.setNombre(source.getNombre());
		result.setDesc(source.getDesc());
				
		if(source.getDepartamentos() != null) {
			result.setDepartamentos(departamentoConverter.convertToListSet(source.getDepartamentos()));
			result.setIdDepartamentos(departamentoConverter.convertToListId(source.getDepartamentos()));
			
		}
		
		return result;
	}

	@Override
	public Tecnologia mapToList(TecnologiaDto dto) {
		Tecnologia result = new Tecnologia();
		result.setId(dto.getId());
		//result.setId(1L);
		result.setNombre(dto.getNombre());
		result.setDesc(dto.getDesc());
		
		if(dto.getDepartamentos() != null) {
			result.setDepartamentos(departamentoConverter.mapToListSet(dto.getDepartamentos()));
			
		}
				
		return result;
	}
	@Override
	public Set<TecnologiaDto> convertToListSet(Set<Tecnologia> source) {
		Set<TecnologiaDto> listaTecnologias = new HashSet<TecnologiaDto>();
		for(Tecnologia tecnologia:source) {
			listaTecnologias.add(this.convert(tecnologia));
		}
		return listaTecnologias;
	}

	@Override
	public Set<Tecnologia> mapToListSet(Set<TecnologiaDto> dto) {
		Set<Tecnologia> listaTecnologias = new HashSet<Tecnologia>();
		for(TecnologiaDto tecnologia:dto) {
			listaTecnologias.add(this.map(tecnologia));
		}
		return listaTecnologias;
	}

	@Override
	public Set<Long> convertToListId(Set<Tecnologia> source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Tecnologia> mapToListId(Set<Long> dto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
