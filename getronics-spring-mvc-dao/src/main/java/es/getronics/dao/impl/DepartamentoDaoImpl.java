package es.getronics.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.getronics.base.dao.impl.GenericDaoImpl;
import es.getronics.bom.Departamento;
import es.getronics.bom.Empleado;
import es.getronics.dao.DepartamentoDao;
import es.getronics.dao.EmpleadoDao;



@Repository("departamentoDao")
public class DepartamentoDaoImpl extends GenericDaoImpl<Departamento, Long> implements DepartamentoDao{

	@Autowired
	private EmpleadoDao empleadoDao;
	
	
	@Autowired
	protected DepartamentoDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
		// TODO Auto-generated constructor stub
	}
	
	
	public void remove(Long id)
	{
		List<Empleado>empleados= empleadoDao.findAll();
		for (Empleado empleado : empleados) {
			if(empleado.getDepartamento()!=null)
			{
				if(empleado.getDepartamento().getId()==id) {
					empleado.setDepartamento(null);
					empleadoDao.update(empleado);
				}
				
			}
		}
		super.remove(id);
	}
}
