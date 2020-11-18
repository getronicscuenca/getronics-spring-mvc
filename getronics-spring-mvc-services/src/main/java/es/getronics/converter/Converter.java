/**
 * 
 */
package es.getronics.converter;

import java.util.Set;

/**
 * @author jgarcia7
 *
 */
public interface Converter<S, D> {
	
	D convert(S source);
	S map (D dto);
	
	D convertToList(S source);
	S mapToList (D dto);
	
	Set<D> convertToListSet(Set<S> source);
	Set<S> mapToListSet(Set<D> dto);
}
