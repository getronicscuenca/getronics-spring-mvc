package es.getronics.converter;

import java.util.Set;

import es.getronics.bom.Empleado;
import es.getronics.dto.EmpleadoDto;

public interface EmpleadoConverter <S, D> {
		
	Set<D> convertToListSet(Set<S> source);
	Set<Empleado> mapToListSet(Set<EmpleadoDto> dto);

}
