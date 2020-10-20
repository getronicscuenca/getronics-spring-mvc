package es.getronics.validators;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;



@Constraint(validatedBy = NombreValidator.class)
public @interface Nombre {
	public String message() default "El nombre no cumple las normas";
}
