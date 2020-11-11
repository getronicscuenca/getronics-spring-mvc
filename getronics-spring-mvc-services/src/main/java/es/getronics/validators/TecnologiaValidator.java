package es.getronics.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import es.getronics.dto.TecnologiaDto;

@Component
public class TecnologiaValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
	
		return TecnologiaDto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors er) {
		
		TecnologiaDto tecnologia =(TecnologiaDto) target;
		
		boolean espaciosBlancosNombre=tecnologia.getNombre().contains(" ");
		boolean demasiadoGrandeNombre= (tecnologia.getNombre().length()>15);
		boolean demasiadoPequenioNombre= (tecnologia.getNombre().length()<3);
		boolean sinNumerosNombre= tecnologia.getNombre().toLowerCase().matches("(([a-z]*)(\s)*)*");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(er, "nombre", "Debe escribir un nombre");
		
		if(espaciosBlancosNombre)
			er.rejectValue("nombre","El nombre no puede tener espacios en blanco");
		
		if(demasiadoGrandeNombre)
			er.rejectValue("nombre","El nombre es demasiado grande");
		if(demasiadoPequenioNombre)
			er.rejectValue("nombre","El nombre es demasiado peque�o");
		if(!sinNumerosNombre)
			er.rejectValue("nombre","El nombre no puede contener n�meros");
		
		boolean espaciosBlancosDescripcion=tecnologia.getDesc().contains(" ");
		boolean demasiadoGrandeDescripcion= (tecnologia.getDesc().length()>15);
		boolean demasiadoPequenioDescripcion= (tecnologia.getDesc().length()<3);
		boolean sinNumerosDescripcion= tecnologia.getDesc().toLowerCase().matches("(([a-z]*)(\s)*)*");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(er, "desc", "Debe escribir una descripcion");
		
		if(espaciosBlancosDescripcion)
			er.rejectValue("desc","La descripci�n no puede tener espacios en blanco");
		
		if(demasiadoGrandeDescripcion)
			er.rejectValue("desc","La descripci�n es demasiado grande");
		if(demasiadoPequenioDescripcion)
			er.rejectValue("desc","La descripci�n es demasiado peque�a");
		if(!sinNumerosDescripcion)
			er.rejectValue("desc","La descripci�n no puede contener n�meros");
	}

}
