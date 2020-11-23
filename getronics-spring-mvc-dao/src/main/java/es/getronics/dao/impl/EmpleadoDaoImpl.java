/**
 * 
 */
package es.getronics.dao.impl;

import java.time.LocalDate;

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
	
	public Empleado insert(Empleado entity)
	{
		entity.setFechaAlta(LocalDate.now());
		return super.insert(entity);
		
	}
	public void Update(Empleado entity)
	{
		entity.setFechaBaja(null);
		entity.setFechaModificacion(LocalDate.now());
		super.update(entity);
	}

	public void saveOrUpdate(Empleado entity)
	{
		entity.setFechaBaja(null);
		entity.setFechaModificacion(LocalDate.now());
		super.update(entity);
	}
	public void remove(Empleado entity)
	{
		entity.setFechaBaja(LocalDate.now());
		super.saveOrUpdate(entity);
	}
	public void remove(Long id)
	{
		Empleado entity = findById(id);
		remove(entity);
	}
	
}
