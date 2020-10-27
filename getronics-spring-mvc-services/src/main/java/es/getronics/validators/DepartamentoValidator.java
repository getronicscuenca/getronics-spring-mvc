package es.getronics.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import es.getronics.dto.DepartamentoDto;
@Component
public class DepartamentoValidator implements Validator {

	@Autowired
	private DepartamentoDto departamentoDto;
	
	@Override
	public boolean supports(Class<?> clazz) {
	
		return DepartamentoDto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors er) {
		ValidationUtils.rejectIfEmptyOrWhitespace(er, "nombre", "nombreVacio");
		ValidationUtils.rejectIfEmpty(er, "desc", "descripcionVacia");
		if(departamentoDto.getAlta()==null) {
			er.rejectValue("alta", "fechaVacia");
		}
		//ValidationUtils.rejectIfEmpty(er, "idEmpleado", "idEmpleado");
		
	}

}
