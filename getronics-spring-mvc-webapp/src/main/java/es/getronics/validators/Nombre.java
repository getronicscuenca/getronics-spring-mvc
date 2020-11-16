package es.getronics.validators;


import javax.validation.Constraint;



@Constraint(validatedBy = NombreValidator.class)
public @interface Nombre {
	public String message() default "El nombre no cumple las normas";
}
