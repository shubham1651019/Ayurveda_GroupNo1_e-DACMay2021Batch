
package com.app.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException { // TODO Auto-generated method
																							// stub

		User user = repo.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException("User Not Found");
		}
		return new CustomUserDetails(user);
	}
	

	/*
	 * public void delete(Long id) { repo.deleteById(id); }
	 */
}
