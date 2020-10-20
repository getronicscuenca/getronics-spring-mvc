package es.getronics.dto;


import java.lang.annotation.Target;

import javax.validation.Constraint;

import es.getronics.controller.NombreValidator;

@Constraint(validatedBy = NombreValidator.class)
public @interface Nombre {
	public String message() default "El nombre no cumple las normas";
}
