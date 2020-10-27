package es.getronics.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import es.getronics.dto.DepartamentoDto;
@Component
public class DepartamentoValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
	
		return DepartamentoDto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors er) {
		ValidationUtils.rejectIfEmptyOrWhitespace(er, "nombre", "nombreVacio");
		ValidationUtils.rejectIfEmpty(er, "desc", "descripcionVacia");
		ValidationUtils.rejectIfEmpty(er, "idEmpleado", "idEmpleado");
		
	}

}
