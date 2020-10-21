package es.getronics.validadores;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import es.getronics.dto.DepartamentoDto;

public class ValidadorDepart implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return DepartamentoDto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		DepartamentoDto depar = (DepartamentoDto)target;
		
		if(depar.getDescripcion().equals("")) {
			errors.rejectValue("descripcion", null, "Debes rellenar el campo (Error controlado por validator)");
			return;
		}
		
	}

}
