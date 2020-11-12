package es.getronics.converter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.getronics.bom.Departamento;
import es.getronics.converter.Converter;
import es.getronics.converter.DepartamentoConverter;
import es.getronics.dao.EmpleadoDao;
import es.getronics.dto.DepartamentoDto;

@Component("departamentoConverter")
public class DepartamentoConverterImpl implements Converter<Departamento, DepartamentoDto>, DepartamentoConverter {
	
	@Autowired
	private EmpleadoDao empleadoDao;
	
	@Override
	public DepartamentoDto convert(Departamento source) {
		DepartamentoDto result = new DepartamentoDto();
		result.setId(source.getId());
		result.setNombre(source.getNombre());
		result.setAlta(source.getAlta());
		result.setDescripcion(source.getDescripcion());
		
		return result;
	}

	@Override
	public Departamento map(DepartamentoDto dto) {
		Departamento res= new Departamento();
		res.setId(dto.getId());
		res.setNombre(dto.getNombre());
		res.setAlta(dto.getAlta());
		res.setDescripcion(dto.getDescripcion());
	
		return res;
	}

	

}
