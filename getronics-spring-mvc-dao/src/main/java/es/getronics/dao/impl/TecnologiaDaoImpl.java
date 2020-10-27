package es.getronics.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import es.getronics.base.dao.impl.GenericDaoImpl;
import es.getronics.bom.Tecnologia;
import es.getronics.dao.TecnologiaDao;

@Repository("TecnologiaDao")
public class TecnologiaDaoImpl extends GenericDaoImpl<Tecnologia, Long> implements TecnologiaDao{

	protected TecnologiaDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
		// TODO Auto-generated constructor stub
	}

}
