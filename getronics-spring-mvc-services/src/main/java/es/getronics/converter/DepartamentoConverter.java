package es.getronics.converter;

import org.springframework.stereotype.Component;

import es.getronics.bom.Departamento;
import es.getronics.dto.DepartamentoDto;

@Component
public class DepartamentoConverter implements Converter<Departamento, DepartamentoDto>{

	@Override
	public DepartamentoDto convert(Departamento source) {
		DepartamentoDto result = new DepartamentoDto();
		result.setId(source.getId());
		result.setNombre(source.getNombre());
		result.setAlta(source.getAlta());
		result.setIdEmpleado(source.getEmpleadoJefe().getId());
		result.setNombreEmpleado(source.getNombreEmpleado());
		return result;
	}

	@Override
	public Departamento map(DepartamentoDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
