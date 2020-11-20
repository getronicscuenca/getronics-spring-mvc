package es.getronics.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.getronics.base.dao.impl.GenericDaoImpl;
import es.getronics.bom.Departamento;
import es.getronics.dao.DepartamentoDao;


@Repository("departamentoDao")
public class DepartamentoDaoImpl extends GenericDaoImpl<Departamento, Long> implements DepartamentoDao{

	@Autowired
	protected DepartamentoDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<Departamento> findByName(String name) {
		DetachedCriteria criteria = createCriteria();
		criteria.add(Restrictions.like("nombre", name));
		return findByCriteria(criteria);
	}

	@Override
	public List<Departamento> findByName(String name) {
		DetachedCriteria criteria = createCriteria();
		criteria.add(Restrictions.like("nombre", name));
		return findByCriteria(criteria);
	}
}
