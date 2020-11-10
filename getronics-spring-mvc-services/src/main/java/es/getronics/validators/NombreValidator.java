package es.getronics.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

//import org.hibernate.CacheMode;

public class NombreValidator implements ConstraintValidator<Nombre,String>{

	
	
	public void initialize(Nombre constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		/*
		boolean espacioBlanco=value.contains(" ");
		boolean demasiadoGrande= (value.length()>15);
		boolean demasiadoPeke= (value.length()<2);
		boolean sinNumeros= value.toLowerCase().matches("[a-z]*");
		*/
		return false;
		
//		if( espacioBlanco || demasiadoGrande || demasiadoPeke || !sinNumeros)
//		{
//			return false;
//		}else
//			
//			return true;
//		}

	
	}
}
