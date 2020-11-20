/**
 * 
 */
package es.getronics.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.getronics.base.dao.impl.GenericDaoImpl;
import es.getronics.bom.Tecnologia;
import es.getronics.dao.TecnologiaDao;

/**
 * Implementa el acceso a datos de la tabla empleados
 * 
 * @author jgarcia
 *
 */
@Repository("tecnologiaDao")
public class TecnologiaDaoImpl extends GenericDaoImpl<Tecnologia, Long> implements TecnologiaDao {

	@Autowired
	protected TecnologiaDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Tecnologia> findByName(String name) {
		DetachedCriteria criteria = createCriteria();
		criteria.add(Restrictions.like("nombre", name));
		return findByCriteria(criteria);
	}

}
