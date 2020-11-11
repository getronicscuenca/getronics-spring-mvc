package es.getronics.dao.impl;


import java.util.HashSet;
import java.util.Set;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import es.getronics.base.dao.impl.GenericDaoImpl;
import es.getronics.bom.Departamento;
import es.getronics.bom.Tecnologia;
import es.getronics.dao.DepartamentoDao;
import es.getronics.dao.TecnologiaDao;

@Repository("tecnologiaDao")
public class TecnologiaDaoImpl extends GenericDaoImpl<Tecnologia, Long> implements TecnologiaDao{
	
	@Autowired
	DepartamentoDao departamentoDao;
	
	@Autowired
	protected TecnologiaDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
		// TODO Auto-generated constructor stub
	}

	
	
	public void remove(Long id)
	{
		//tecnologia a borrar
		Tecnologia tecnologia = findById(id);
		//lista de departamentos que usan esa tecnologia
		Set<Departamento> Departamentos =tecnologia.getDepartamentos();
		//recorremos cada departamento que tiene esa tecnologia
		for (Departamento departamento : Departamentos) {
			//lista de tecnologias de este departamento
			Set<Tecnologia> tecnologias=departamento.getTecnologias();
			//si en la lista de tecnologias esta la que vamos a borrar la eliminiamos y actualizamos el departamento
			if(tecnologias.contains(tecnologia))
			{
				tecnologias.remove(tecnologia);
				departamento.setTecnologias(tecnologias);
				departamentoDao.update(departamento);
			}
			
		}
		//borramos la lista de departamentos que tienen la tecnologia
		tecnologia.setDepartamentos(new HashSet<Departamento>());
		//actualizamos
		update(tecnologia);
		super.remove(id);
	}
}
