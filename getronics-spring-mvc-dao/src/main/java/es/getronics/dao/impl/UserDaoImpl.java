package es.getronics.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.getronics.base.dao.exception.GetronicsDaoException;
import es.getronics.base.dao.impl.GenericDaoImpl;
import es.getronics.bom.User;
import es.getronics.dao.UserDao;

@Repository("userDao")
public class UserDaoImpl extends GenericDaoImpl<User, Long> implements UserDao {

	@Autowired
	protected UserDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Override
	public User findByName(String username) throws GetronicsDaoException {
		DetachedCriteria criteria = createCriteria();
		criteria.add(Restrictions.like("username", username));
		List<User> found = findByCriteria(criteria);
		if(!found.isEmpty() && found.get(0) != null) {
			return found.get(0);
		}else {
			 throw new GetronicsDaoException("El usuario " + username +" no existe.");
		}
		//return !found.isEmpty() ? found.get(0) : null;
	}

}
