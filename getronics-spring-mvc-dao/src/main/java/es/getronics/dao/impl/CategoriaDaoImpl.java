/**
 * @file CategoriaDaoImpl.java
 * @date 11 nov. 2020
 * @time 14:01:24
 * 
 */
package es.getronics.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.getronics.base.dao.impl.GenericDaoImpl;
import es.getronics.bom.Categoria;
import es.getronics.dao.CategoriaDao;

/**
 * @author alatorre
 *
 * 
 */
@Repository("categoriaDao")
public class CategoriaDaoImpl extends GenericDaoImpl<Categoria,Long> implements CategoriaDao{

	/**
	 * Constructor
	 * @param sessionFactory
	 */
	@Autowired
	protected CategoriaDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
		// TODO Auto-generated constructor stub
	}


	
}
