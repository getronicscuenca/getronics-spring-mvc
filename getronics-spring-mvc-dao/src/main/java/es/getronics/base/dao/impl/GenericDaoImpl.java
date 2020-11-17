/**
 * 
 */
package es.getronics.base.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import es.getronics.base.dao.GenericDao;
import es.getronics.base.dao.exception.GetronicsDaoException;
import es.getronics.bom.Departamento;

/**
 * @author jgarcia
 *
 */
/**
 * Clase base para operaciones DAO.
 * 
 * @param <T>
 *            Tipo de objeto a implementar por el generico.
 * @param <ID>
 *            Identificador del objeto.
 */

public abstract class GenericDaoImpl<T, ID extends Serializable> extends
		HibernateDaoSupport implements GenericDao<T, ID> {

	/** Clase asociada. */
	private Class<T> clazz;

	/**
	 * Constructor.
	 */
	@SuppressWarnings("unchecked")
	protected GenericDaoImpl(SessionFactory sessionFactory) {
		this.clazz = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		
		setSessionFactory(sessionFactory);
	}

	/**
	 * Devuelve la clase asociada
	 * 
	 * @return the clazz
	 */
	protected Class<T> getClazz() {
		return clazz;
	}

	public List<T> findAll() {
		return getHibernateTemplate().loadAll(clazz);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findAllOrderBy(String[] orderBy, boolean asc) {
		DetachedCriteria criteria = DetachedCriteria.forClass(clazz); 
		int nOrderBy = orderBy.length;
		for(int indexOrder = 0; indexOrder < nOrderBy; indexOrder++) {
			Order order;
			if(asc) {
				order = Order.asc(orderBy[indexOrder]);
			} else {
				order = Order.desc(orderBy[indexOrder]);
			}
			
			criteria.addOrder(order);
		}
		
		return (List<T>) getHibernateTemplate().findByCriteria(criteria);
	}

	public T findById(ID id) {
		return (T) getHibernateTemplate().get(clazz, id);
	}

	public T merge(T entity) {
		return (T) getHibernateTemplate().merge(entity);
	}

	public void update(T entity) {
		getHibernateTemplate().update(entity);
	}

	public void saveOrUpdate(T entity) {
		getHibernateTemplate().saveOrUpdate(entity);
	}

	@SuppressWarnings("unchecked")
	public T insert(T entity) {
		ID id = (ID) getHibernateTemplate().save(entity);
		return (findById(id));
	}

	public void remove(T entity) {
		getHibernateTemplate().delete(entity);
	}
	
	public void remove(ID id) {
		T entity = findById(id);
		if(entity != null) {
			remove(entity);
		}
	}

	public List<T> findByExample(T example) {
		Class<T> clazz = getClazz();
		List<?> raw = getHibernateTemplate().findByExample(example);
		List<T> safe = new ArrayList<T>();
		for (Object o : raw) {
			safe.add(clazz.cast(o));
		}
		return safe;
	}
	
	public List<T> findByCriteria(DetachedCriteria criteria) {
		return getHibernateTemplate().findByCriteria(criteria);
	}
	
	public DetachedCriteria createCriteria() {
		return DetachedCriteria.forClass(getClazz());
	}

	public void refresh(T entity) {
		getHibernateTemplate().refresh(entity);
	}

	/**
	 * Lanzar exception.
	 * 
	 * @param mensaje
	 *            the mensaje
	 * @throws getronicsDaoException
	 *             the dao runtime exception
	 */
	protected void lanzarException(String mensaje) throws GetronicsDaoException {
		throw new GetronicsDaoException(mensaje);
	}

	/**
	 * Builds the criteria.
	 * 
	 * @param criteria
	 *            the criteria
	 * @param alias
	 *            the alias
	 * @param filtros
	 *            the filtros
	 * @param orden
	 *            the orden
	 */
	protected void buildCriteria(Criteria criteria,
			HashMap<String, Object> alias, ArrayList<Criterion> filtros,
			ArrayList<Order> orden) {
		Iterator<?> it = alias.keySet().iterator();
		while (it.hasNext()) {
			String key = (String) it.next();
			criteria.createAlias(key, (String) alias.get(key),
					CriteriaSpecification.LEFT_JOIN);
		}

		for (int i = 0; i < filtros.size(); i++)
			criteria.add(filtros.get(i));
		if (orden != null) {
			for (int i = 0; i < orden.size(); i++) {
				criteria.addOrder(orden.get(i));
			}
		}
	}

	public void doRollback() {
		getHibernateTemplate().execute(new HibernateCallback<T>() {

			@Override
			public T doInHibernate(Session session) throws HibernateException, SQLException {
				session.getTransaction().rollback();
				return null;
			}
			
		});
	}
}
