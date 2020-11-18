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
		
		DepartamentoDto departamento =(DepartamentoDto) target;
		
		boolean espaciosBlancosNombre=departamento.getNombre().contains(" ");
		boolean demasiadoGrandeNombre= (departamento.getNombre().length()>15);
		boolean demasiadoPequenioNombre= (departamento.getNombre().length()<3);
		boolean sinNumerosNombre= departamento.getNombre().toLowerCase().matches("(([a-z]*)(\s)*)*");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(er, "nombre", "Debe escribir un nombre");
		
		if(espaciosBlancosNombre)
			er.rejectValue("nombre","El nombre no puede tener espacios en blanco");
		
		if(demasiadoGrandeNombre)
			er.rejectValue("nombre","El nombre es demasiado grande");
		if(demasiadoPequenioNombre)
			er.rejectValue("nombre","El nombre es demasiado pequeño");
		if(!sinNumerosNombre)
			er.rejectValue("nombre","El nombre no puede contener números");
		
		boolean espaciosBlancosDescripcion=departamento.getDesc().contains(" ");
		boolean demasiadoGrandeDescripcion= (departamento.getDesc().length()>15);
		boolean demasiadoPequenioDescripcion= (departamento.getDesc().length()<3);
		boolean sinNumerosDescripcion= departamento.getDesc().toLowerCase().matches("(([a-z]*)(\s)*)*");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(er, "desc", "Debe escribir una descripcion");
		
		if(espaciosBlancosDescripcion)
			er.rejectValue("desc","La descripción no puede tener espacios en blanco");
		
		if(demasiadoGrandeDescripcion)
			er.rejectValue("desc","La descripción es demasiado grande");
		if(demasiadoPequenioDescripcion)
			er.rejectValue("desc","La descripción es demasiado pequeña");
		if(!sinNumerosDescripcion)
			er.rejectValue("desc","La descripción no puede contener números");
	}

}
