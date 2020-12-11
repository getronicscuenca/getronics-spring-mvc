package es.getronics.validators;

import es.getronics.exceptions.DescripcionLargaException;
import es.getronics.exceptions.NombreLargoException;

public interface GenericValidator<T> {

	boolean supports(Class<T> clazz);
	void validate(T target) throws NombreLargoException, DescripcionLargaException;

}
