package com.lcdd.backend;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// Public pages
		
		// Private pages (all other pages)
		
		// Login form
		
		// Logout
		
		// Disable CSRF at the moment
		http.csrf().disable();
	}
}

