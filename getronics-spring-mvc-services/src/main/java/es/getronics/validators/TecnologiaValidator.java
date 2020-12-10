package es.getronics.validators;

public class TecnologiaValidator<T> implements GenericValidator<T> {

	@Override
	public boolean supports(Class<T> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(T target) {
		if(target=="" || target==null) {
			throw new NullPointerException();
		}
	}

	



}
