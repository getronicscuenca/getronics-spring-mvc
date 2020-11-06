package es.getronics.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.getronics.base.dao.impl.GenericDaoImpl;
import es.getronics.bom.Tecnologias;
import es.getronics.dao.TecnologiasDao;

@Repository("tecnologiasDao")
public class TecnologiasDaoImpl extends GenericDaoImpl<Tecnologias,Long> implements TecnologiasDao {

	@Autowired
	protected TecnologiasDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
		// TODO Auto-generated constructor stub
	}

}
