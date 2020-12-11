package es.getronics.base.services.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import es.getronics.base.services.GenericService;
import es.getronics.exceptions.DescripcionLargaException;
import es.getronics.exceptions.NombreLargoException;
import es.getronics.validators.GenericValidator;

public abstract class GenericServiceImpl<T1, T2, ID extends Serializable> extends HibernateDaoSupport
		implements GenericService<T1, T2, ID> {

	@Override
	public T1 findById(ID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T1> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T1> findAllOrderBy(String[] orderBy, boolean asc) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Autowired
	GenericValidator<T1> validator;

	public T1 insert(T1 entity) {
		try {
			validator.validate(entity);
			getHibernateTemplate().save(entity);
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (NombreLargoException e) {
			e.printStackTrace();
		} catch (DescripcionLargaException e) {
			e.printStackTrace();
		}
		return entity;
	}

	@Override
	public void update(T1 entity) {
		try {
			validator.validate(entity);
			getHibernateTemplate().update(entity);
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (NombreLargoException e) {
			e.printStackTrace();
		} catch (DescripcionLargaException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void saveOrUpdate(T1 entity) {
		try {
			validator.validate(entity);
			getHibernateTemplate().update(entity);
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (NombreLargoException e) {
			e.printStackTrace();
		} catch (DescripcionLargaException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remove(T1 entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(ID id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<T1> findByExample(T1 example) {
		// TODO Auto-generated method stub
		return null;
	}

}
