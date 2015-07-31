package com.misys.security;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.misys.dao.UserDAO;
import com.misys.domain.entity.UserMaster;
import com.misys.exception.DBRecordNotFoundException;



public class CustomUserDetailsService implements UserDetailsService {

	@Inject
	UserDAO userDao;

	public UserDetails loadUserByUsername(String email)
			throws UsernameNotFoundException {
		UserDetails userDetails = null;
		try {
			UserMaster user = userDao.findByEmail(email);
			
			userDetails = new User(user.getEmail(), user.getPassword(),
					true, true, true, true,
					buildDefaultGrantedAuthority());
			return userDetails;
		} catch (DBRecordNotFoundException e) {
			throw new UsernameNotFoundException("Unable to retrieve user", e);
		}
	}

	private List<GrantedAuthority> buildDefaultGrantedAuthority() {
		List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
		grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
		return grantedAuths;
	}

}
