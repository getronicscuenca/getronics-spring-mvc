package es.getronics.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
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

}
