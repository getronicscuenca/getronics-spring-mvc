package es.getronics.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.getronics.base.dao.impl.GenericDaoImpl;
import es.getronics.bom.Departamento;
import es.getronics.dao.DepartamentoDao;

@Repository("departamentoDao")
public class DepartamentoDaoImpl extends GenericDaoImpl<Departamento, Long> implements DepartamentoDao {

	@Autowired
	protected DepartamentoDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
		// TODO Auto-generated constructor stub
	}
	
}
