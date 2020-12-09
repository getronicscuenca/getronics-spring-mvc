package es.getronics.validators;

public interface GenericValidator<T> {

	void saveOrUpdate(T entity);

	T insert(T entity);

}
