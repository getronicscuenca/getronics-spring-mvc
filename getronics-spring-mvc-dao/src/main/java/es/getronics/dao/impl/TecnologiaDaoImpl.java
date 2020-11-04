package es.getronics.dao.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.getronics.base.dao.impl.GenericDaoImpl;
import es.getronics.bom.Departamento;
import es.getronics.bom.Empleado;
import es.getronics.bom.Tecnologia;
import es.getronics.dao.TecnologiaDao;

@Repository("tecnologiaDao")
public class TecnologiaDaoImpl extends GenericDaoImpl<Tecnologia, Long> implements TecnologiaDao{
	
	@Autowired
	protected TecnologiaDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
		// TODO Auto-generated constructor stub
	}

	
	
	public void remove(Long id)
	{
		Tecnologia tecnologia = findById(id);
		tecnologia.setDepartamentos(new HashSet<Departamento>());
		update(tecnologia);
		super.remove(id);
	}
}
