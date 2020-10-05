/**
 * 
 */
package es.getronics.mapper;

import java.util.List;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;

/**
 * @author jgarcia
 *
 */
public class MapperFactory {

	private List<Converter> converters;
	
	public ModelMapper create() {
		ModelMapper modelMaper = new ModelMapper();
		if(converters != null) {
			for(Converter converter: converters) {
				modelMaper.addConverter(converter);
			}
		}
		return modelMaper;
	}

	/**
	 * @return the converters
	 */
	public List<Converter> getConverters() {
		return converters;
	}

	/**
	 * @param converters the converters to set
	 */
	public void setConverters(List<Converter> converters) {
		this.converters = converters;
	}
	
	
}
