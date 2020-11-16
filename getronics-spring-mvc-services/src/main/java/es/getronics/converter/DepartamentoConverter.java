package es.getronics.converter;



import org.springframework.stereotype.Component;

import es.getronics.bom.Departamento;
import es.getronics.dto.DepartamentoDto;

@Component
public class DepartamentoConverter implements Converter<Departamento, DepartamentoDto> {

	
	@Override
	public DepartamentoDto convert(Departamento source) {
		DepartamentoDto result = new DepartamentoDto();
		result.setId(source.getId());
		result.setNombre(source.getNombre());
		result.setAlta(source.getAlta());
		result.setDesc(source.getDesc());
		result.setIdEmpleado(source.getIdEmpleado());
		result.setNombreEmpleado(source.getNombreEmpleado());
		return result;
	}

	@Override
	public Departamento map(DepartamentoDto dto) {
		Departamento entity = new Departamento();
		entity.setId(dto.getId());
		entity.setNombre(dto.getNombre());
		entity.setAlta(dto.getAlta());
		entity.setDesc(dto.getDesc());
		entity.setIdEmpleado(dto.getIdEmpleado());
		entity.setNombreEmpleado(dto.getNombreEmpleado());
		return entity;
	}

}
