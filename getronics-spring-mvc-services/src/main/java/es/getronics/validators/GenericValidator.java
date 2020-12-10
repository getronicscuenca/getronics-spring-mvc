package es.getronics.validators;

public interface GenericValidator<T> {

	boolean supports(Class<T> clazz);
	void validate(T target);

}
