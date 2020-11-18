package es.getronics.converter;

import java.util.Set;

import es.getronics.bom.Tecnologia;
import es.getronics.dto.TecnologiaDto;

public interface TecnologiaConverter <S, D> {
	
	D convertToList(S source);
	S mapToList (D dto);
	
	Set<D> convertToListSet(Set<S> source);
	Set<Tecnologia> mapToListSet(Set<TecnologiaDto> dto);
	
	Set<Long> convertToListId(Set<S> source);
	Set<S> mapToListId(Set<Long> dto);

}
