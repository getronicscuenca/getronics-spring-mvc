package es.getronics.base.services.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.SessionFactory;
import org.modelmapper.ModelMapper;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import es.getronics.base.dao.GenericDao;
import es.getronics.base.services.GenericService;
import es.getronics.bom.Departamento;
import es.getronics.dto.DepartamentoDto;
import es.getronics.validators.GenericValidator;

public abstract class GenericServiceImpl<T1, T2, ID extends Serializable> extends HibernateDaoSupport
		implements GenericService<T1, T2, ID>, GenericValidator<T1> {

	private GenericDao dao;
	private ModelMapper modelMapper;

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

	@Override
	public void update(T1 entity) {
		try {
		validate(entity);
		getHibernateTemplate().update(entity);
		}catch(NullPointerException e) {
			System.out.println("no puede estar vacio");
		}
	}

	@Override
	public void saveOrUpdate(T1 entity) {
		try {
			validate(entity);
			getHibernateTemplate().update(entity);
			}catch(NullPointerException e) {
				System.out.println("no puede estar vacio");
			}
	}

	public T1 insert(T1 entity){
		try {
			validate(entity);
			getHibernateTemplate().save(entity);
			}catch(NullPointerException e) {
				System.out.println("no puede estar vacio");
			}
		return entity;
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
