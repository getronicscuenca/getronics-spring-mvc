package es.getronics.converter;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;


import es.getronics.bom.Departamento;
import es.getronics.bom.Empleado;
import es.getronics.dto.DepartamentoDto;
import es.getronics.dto.EmpleadoDto;

public class DepartamentoConverter implements Converter<Departamento, DepartamentoDto>{

	@Override
	public DepartamentoDto convert(MappingContext<Departamento, DepartamentoDto> context) {
		Departamento source = context.getSource();
		DepartamentoDto result = new DepartamentoDto();
		result.setId(source.getId());
		result.setNombre(source.getNombre());
		result.setAlta(source.getAlta());
		return result;
	}

	

}
