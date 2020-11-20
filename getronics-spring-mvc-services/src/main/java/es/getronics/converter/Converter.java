/**
 * 
 */
package es.getronics.converter;



/**
 * @author jgarcia7
 *
 */
public interface Converter<S, D> {
	
	D convert(S source);
	S map (D dto);

}
