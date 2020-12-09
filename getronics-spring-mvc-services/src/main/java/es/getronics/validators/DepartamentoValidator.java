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
		DepartamentoDto departamento = DepartamentoDto.class.cast(target);
		
		ValidationUtils.rejectIfEmptyOrWhitespace(er, "nombre", "nombre_vacio");
		
		boolean espacioBlanco=departamento.getNombre().contains(" ");
		boolean demasiadoGrande= (departamento.getNombre().length()>20);
		boolean demasiadoPeke= (departamento.getNombre().length()<2);
		boolean sinNumeros= departamento.getNombre().toLowerCase().matches("(([a-z]*)(\s)*)*");
		
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
