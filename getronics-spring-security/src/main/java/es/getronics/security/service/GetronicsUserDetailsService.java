package es.getronics.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import es.getronics.bom.Privilege;
import es.getronics.bom.Role;
import es.getronics.bom.User;
import es.getronics.dao.UserDao;

public class GetronicsUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDao userDao;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		
		User user = userDao.findByName(username);
				
		/*if((user.getPassword().equals("user")&& user.getUsername().equals("user"))
			||(user.getUsername().equals("manager")&& user.getPassword().equals("manager"))
			||(user.getUsername().equals("admin")&& user.getPassword().equals("admin"))
			||(user.getUsername().equals("superuser")&& user.getPassword().equals("superuser"))) {*/
			
		UserDetails userDetails;
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		for( Role role : user.getRoles()) {
			for (Privilege privilege : role.getPrivileges()) {
				authorities.add(new GrantedAuthorityImpl(privilege.getName()));
			}
		}
		
		userDetails = new org.springframework.security.core.userdetails.User(
				user.getUsername(), 
				user.getPassword(),
				user.isEnabled(),
				true,
				true,
				true,
				authorities);
						
		return userDetails;
		
	}

}
