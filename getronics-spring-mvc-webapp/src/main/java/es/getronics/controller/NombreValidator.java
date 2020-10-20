package es.getronics.controller;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import es.getronics.dto.Nombre;

public class NombreValidator implements ConstraintValidator<Nombre,String>{

	
	@Override
	public void initialize(Nombre constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		
		boolean espacioBlanco=value.contains(" ");
		boolean demasiadoGrande= (value.length()>15);
		boolean demasiadoPeke= (value.length()<2);
		boolean sinNumeros= value.toLowerCase().matches("[a-z]*");
		
		if( espacioBlanco || demasiadoGrande || demasiadoPeke || !sinNumeros)
		{
			return false;
		}else
			
			return true;
	}

	

}
