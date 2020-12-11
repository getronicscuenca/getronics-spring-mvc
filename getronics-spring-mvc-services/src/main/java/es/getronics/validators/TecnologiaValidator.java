package es.getronics.validators;

import es.getronics.dto.TecnologiaDTO;
import es.getronics.exceptions.DescripcionLargaException;
import es.getronics.exceptions.NombreLargoException;

public class TecnologiaValidator<T> implements GenericValidator<T> {

	@Override
	public boolean supports(Class<T> clazz) {
		
		return TecnologiaDTO.class.equals(clazz);
	}

	@Override
	public void validate(T target) throws NombreLargoException, DescripcionLargaException{
		TecnologiaDTO tec=(TecnologiaDTO) target;
		
		if(target==null) {
			throw new NullPointerException();
		}
		if(tec.getNombre()==null) {
			throw new NullPointerException("el nombre no puede estar vacio");
		}
		if(tec.getNombre().length()>=25) {
			throw new NombreLargoException("El nombre es demasiado largo");

		}
		if(tec.getDescripcion()==null) {
			throw new NullPointerException("la descripcion no puede estar vacia");
		}
		if(tec.getDescripcion().length()>=100) {
			throw new DescripcionLargaException("la descripcion es demasiado larga");
		}
	}

	



}
