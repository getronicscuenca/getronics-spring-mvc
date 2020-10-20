package es.getronics.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import es.getronics.dto.DepartamentoDto;

public class DepartamentoValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors er) {
		ValidationUtils.rejectIfEmptyOrWhitespace(er, "nombre", "nombre_vacio");
		DepartamentoDto departamento =(DepartamentoDto) target;
		
		boolean espacioBlanco=departamento.getNombre().contains(" ");
		boolean demasiadoGrande= (departamento.getNombre().length()>15);
		boolean demasiadoPeke= (departamento.getNombre().length()<2);
		boolean sinNumeros= departamento.getNombre().toLowerCase().matches("[a-z]*");
		
		if(espacioBlanco)
			er.rejectValue("nombre","espaciosBlancos");
		
		if(demasiadoGrande)
			er.rejectValue("nombre","demasiadoGrande");
		if(demasiadoPeke)
			er.rejectValue("nombre","demasiadoPeke");
		if(!sinNumeros)
			er.rejectValue("nombre","conNumeros");
	}

}
