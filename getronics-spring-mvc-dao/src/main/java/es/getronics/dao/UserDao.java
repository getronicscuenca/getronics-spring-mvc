package es.getronics.dao;

import es.getronics.base.dao.GenericDao;
import es.getronics.bom.User;

public interface UserDao extends GenericDao<User, Long> {

	User findByName(String username);

}
