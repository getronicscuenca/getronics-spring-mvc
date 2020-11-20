/**
 * 
 */
package es.getronics.converter;

import es.getronics.dto.KeyValueItem;

/**
 * @author jgarcia7
 *
 */
public interface Converter<S, D> {
	
	D convert(S source);
	S map (D dto);
	KeyValueItem mapItems (S source);
}
