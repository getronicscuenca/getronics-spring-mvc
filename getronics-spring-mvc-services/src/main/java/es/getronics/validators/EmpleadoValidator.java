package es.getronics.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import es.getronics.dto.EmpleadoDto;
@Component
public class EmpleadoValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
	
		return EmpleadoDto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors er) {
		
		EmpleadoDto empleado =(EmpleadoDto) target;
		
		boolean espaciosBlancosNombre=empleado.getNombre().contains(" ");
		boolean demasiadoGrandeNombre= (empleado.getNombre().length()>15);
		boolean demasiadoPequenioNombre= (empleado.getNombre().length()<3);
		boolean sinNumerosNombre= empleado.getNombre().toLowerCase().matches("(([a-z]*)(\s)*)*");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(er, "nombre", "Debe escribir un nombre");
		
		if(espaciosBlancosNombre)
			er.rejectValue("nombre","El nombre no puede tener espacios en blanco");
		
		if(demasiadoGrandeNombre)
			er.rejectValue("nombre","El nombre es demasiado grande");
		if(demasiadoPequenioNombre)
			er.rejectValue("nombre","El nombre es demasiado pequeño");
		if(!sinNumerosNombre)
			er.rejectValue("nombre","El nombre no puede contener números");
		
		boolean espaciosBlancosApellido1=empleado.getApellido1().contains(" ");
		boolean demasiadoGrandeApellido1= (empleado.getApellido1().length()>15);
		boolean demasiadoPequenioApellido1= (empleado.getApellido1().length()<3);
		boolean sinNumerosApellido1= empleado.getApellido1().toLowerCase().matches("(([a-z]*)(\s)*)*");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(er, "apellido1", "Debe escribir el primer apellido");
		
		if(espaciosBlancosApellido1)
			er.rejectValue("apellido1","El primer apellido no puede tener espacios en blanco");
		
		if(demasiadoGrandeApellido1)
			er.rejectValue("apellido1","El primer apellido es demasiado grande");
		if(demasiadoPequenioApellido1)
			er.rejectValue("apellido1","El primer apellido es demasiado pequeño");
		if(!sinNumerosApellido1)
			er.rejectValue("apellido1","El primer apellido no puede contener números");
		
		boolean espaciosBlancosApellido2=empleado.getApellido2().contains(" ");
		boolean demasiadoGrandeApellido2= (empleado.getApellido2().length()>15);
		boolean demasiadoPequenioApellido2= (empleado.getApellido2().length()<3);
		boolean sinNumerosApellido2= empleado.getApellido2().toLowerCase().matches("(([a-z]*)(\s)*)*");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(er, "apellido2", "Debe escribir el segundo apellido");
		
		if(espaciosBlancosApellido2)
			er.rejectValue("apellido2","El segundo apellido no puede tener espacios en blanco");
		
		if(demasiadoGrandeApellido2)
			er.rejectValue("apellido2","El segundo apellido es demasiado grande");
		if(demasiadoPequenioApellido2)
			er.rejectValue("apellido2","El segundo apellido es demasiado pequeño");
		if(!sinNumerosApellido2)
			er.rejectValue("apellido2","El segundo apellido no puede contener números");
	}

}
