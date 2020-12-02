package es.getronics.security.provider;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import es.getronics.base.dao.exception.GetronicsDaoException;

public class GetronicsAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

	private UserDetailsService userDetailsService;
	
	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		
	}
	
	/*@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		authentication.getAuthorities().
		
	}*/


	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		
		if(userDetails!=null) {
            if(userDetailsService.loadUserByUsername(userDetails.getUsername()).getPassword().equals(authentication.getCredentials())) {
               
            }else {
                throw new GetronicsDaoException("La password es incorrecta");
            }
        }
		
		return userDetails;
	}

	public void setUserDetailsService(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

}
