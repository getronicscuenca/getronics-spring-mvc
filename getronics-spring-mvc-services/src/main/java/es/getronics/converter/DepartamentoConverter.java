package es.getronics.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.getronics.bom.Departamento;
import es.getronics.dto.DepartamentoDto;

@Component
public class DepartamentoConverter implements Converter<Departamento, DepartamentoDto>{

	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public DepartamentoDto convert(Departamento source) {
		DepartamentoDto result = new DepartamentoDto();
		result.setId(source.getId());
		result.setNombre(source.getNombre());
		result.setAlta(source.getAlta());
		result.setIdEmpleado(source.getIdEmpleado());
		result.setNombreEmpleado(source.getNombreEmpleado());
		return result;
	}

	@Override
	public Departamento map(DepartamentoDto dto) {
		Departamento entity= modelMapper.map(dto,Departamento.class);
		return entity;
	}

	

}
