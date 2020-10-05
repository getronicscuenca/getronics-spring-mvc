/**
 * 
 */
package es.getronics.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.getronics.base.dao.impl.GenericDaoImpl;
import es.getronics.bom.Empleado;
import es.getronics.dao.EmpleadoDao;

/**
 * Implementa el acceso a datos de la tabla empleados
 * 
 * @author jgarcia
 *
 */
@Repository("empleadoDao")
public class EmpleadoDaoImpl extends GenericDaoImpl<Empleado, Long> implements EmpleadoDao {

	@Autowired
	protected EmpleadoDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
		// TODO Auto-generated constructor stub
	}


}
