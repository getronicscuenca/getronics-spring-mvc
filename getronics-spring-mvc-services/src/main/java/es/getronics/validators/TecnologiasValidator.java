package es.getronics.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import es.getronics.dto.TecnologiasDto;

@Component
public class TecnologiasValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return TecnologiasDto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "nombreVacio");
		ValidationUtils.rejectIfEmpty(errors, "descripcion", "descripcionVacia");
	}

}
