package es.getronics.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.type.LongType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.getronics.bom.Tecnologia;
import es.getronics.dao.TecnologiaDao;

@Repository("tecnologiaDao")
public class TecnologiaDaoImpl implements TecnologiaDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Tecnologia> findAll() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().find("from Tecnologia");
	}

	public Tecnologia insert(Tecnologia entity) {
		sessionFactory.getCurrentSession().save(entity);
		return entity;

	}

	@Override
	public Tecnologia update(Tecnologia entity) {
		sessionFactory.getCurrentSession().update(entity);
		return entity;
	}

	@Override
	public Tecnologia findById(Long id) {
		 return (Tecnologia) sessionFactory.getCurrentSession().get(Tecnologia.class, id);
	
	}

}
