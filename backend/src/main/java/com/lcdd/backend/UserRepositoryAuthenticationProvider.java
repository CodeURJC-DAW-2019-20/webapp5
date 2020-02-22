package com.lcdd.backend;

import java.util.ArrayList;

import javax.naming.AuthenticationException;

import org.apache.catalina.User;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryAuthenticationProvider{
	@Autowired
	private UserRepository
	
	@Override
	public Authentication authentication(Authentication auth)throws AuthenticationException{
		
		User user = userRepository.findByName(auth.getName());
		
		if (user == null) {
			throw new BadCredentialsException("User not found");
		}
		
		String password = (String) auth.getCredentials();
		if(!new BCryptPasswordEncoder().matches(password, user.getPasswordHash())) {
			throw new BadCredentialsException("Contraseña incorrecta");
		}
		
		List<GrantedAuthority> role = new ArrayList<>();
		for (String role : user.getRoles()) {
				role.add(new SimpleGrantedAuthoriry(role));
		}
		
		return new UsernamePasswordAuthenticationToken(user.getName(), password,role);
	}
	
	
	
	
	
	
}