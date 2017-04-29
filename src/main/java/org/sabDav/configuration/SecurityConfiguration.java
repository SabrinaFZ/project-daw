package org.sabDav.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	public CustomAuthenticationProvider authenticationProvider;
	
	@Autowired
	public CustomSuccessHandler customSuccessHandler;
	 
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Database authentication provider
		auth.authenticationProvider(authenticationProvider);
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll();
		http.authorizeRequests().antMatchers("/login").permitAll();
		http.authorizeRequests().antMatchers("/signup").permitAll();
		http.authorizeRequests().antMatchers("/home").access("hasRole('USER') or hasRole('ADMIN')");
		http.authorizeRequests().antMatchers("/admin/**").access("hasRole('ADMIN')");
		http.authorizeRequests().anyRequest().authenticated();
		http.formLogin().loginPage("/login").usernameParameter("username")
		.passwordParameter("password").successHandler(customSuccessHandler)
		.failureUrl("/login?error").permitAll().and().csrf();
		http.logout().logoutUrl("/logout").logoutSuccessUrl("/login?logout")
		.permitAll();
	}
	
}
