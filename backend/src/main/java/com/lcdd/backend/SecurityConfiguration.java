package com.lcdd.backend;

import org.springframework.http.HttpMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	public UserRepositoryAuthenticationProvider authenticationProvider;
	
	@Override 
	protected void configure(HttpSecurity http)throws Exception{
		// Public pages
		http.authorizeRequests().antMatchers("/").permitAll();
		http.authorizeRequests().antMatchers("/login").permitAll();
		http.authorizeRequests().antMatchers("/about_us").permitAll();
		http.authorizeRequests().antMatchers("/contact").permitAll();
		http.authorizeRequests().antMatchers("/events").permitAll();
		http.authorizeRequests().antMatchers("/event-template").permitAll();
		http.authorizeRequests().antMatchers("/merchandaidsing").permitAll();
		http.authorizeRequests().antMatchers("/merch-template").permitAll();
		http.authorizeRequests().antMatchers("/register").permitAll();
		http.authorizeRequests().antMatchers("/404").permitAll();
		http.authorizeRequests().antMatchers("/login_error").permitAll();

		http.authorizeRequests().antMatchers("/eventForm").permitAll();
		http.authorizeRequests().antMatchers("/purchaseMerch").permitAll();
		
		
		// Private pages
		http.authorizeRequests().antMatchers("/merch-form").hasAnyRole("ADMIN");
		http.authorizeRequests().antMatchers("/event-form").hasAnyRole("ADMIN");
		http.authorizeRequests().antMatchers("/admin").hasAnyRole("ADMIN");
		http.authorizeRequests().antMatchers("/logout").authenticated();
		http.authorizeRequests().antMatchers("/dashboard").hasAnyRole("ADMIN");
		
		// Login form
		http.formLogin().loginPage("/login");
		http.formLogin().usernameParameter("username");
		http.formLogin().passwordParameter("password");
		http.formLogin().defaultSuccessUrl("/");
		http.formLogin().failureUrl("/loginerror");
		
		// Log out
		http.logout().logoutUrl("/logout");
		http.logout().invalidateHttpSession(true);
		http.logout().logoutSuccessUrl("/");
	
		http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/user/**").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/user/**").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/registerUser/**").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/purchaseMerch/**").permitAll();
		
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/userRegisterEvent/**").permitAll();

		http.authorizeRequests().anyRequest().permitAll();
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// Database authentication provider
		auth.authenticationProvider(authenticationProvider);
	}

}
