package es.getronics.converter;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import es.getronics.bom.Departamento;
import es.getronics.dto.DepartamentoDto;
public class DepartamentoConverter implements Converter<Departamento,DepartamentoDto>{

	@Override
	public DepartamentoDto convert(MappingContext<Departamento, DepartamentoDto> context) {
		Departamento source = context.getSource();
		DepartamentoDto result = new DepartamentoDto();
		result.setId(source.getId());
		result.setNombre(source.getNombre());
		result.setFecha(source.getFecha());
		result.setDescripcion(source.getDescripcion());
		return result;
	}

}
