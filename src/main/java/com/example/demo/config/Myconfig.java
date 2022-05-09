package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.example.demo.security.CustomeUserDetailsService;

import ch.qos.logback.core.pattern.color.BoldCyanCompositeConverter;


@Configuration
public class Myconfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private CustomeUserDetailsService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		//home url is public url, anyone can access this url, dashboard is private url only authenticate user can access this url
		/*
		 * http .authorizeRequests() .antMatchers("/home").permitAll()
		 * .antMatchers("/dashboard").authenticated() .and() .formLogin() .and()
		 * .httpBasic();
		 */
		
		//denyAll request
		/*
		 * http .authorizeRequests() .anyRequest() .denyAll() .and() .httpBasic();
		 */
		
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/user/home").permitAll()
		.antMatchers("/user/register").permitAll()
		.antMatchers("/user/dashboard").authenticated()
		.and()
		.formLogin()
		.and()
		.httpBasic();		
	}
	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception { auth.inMemoryAuthentication()
	 * .withUser("Ansar").password("ansar123").authorities("admin") .and()
	 * .withUser("Lubna").password("lubna123").authorities("user") .and()
	 * .passwordEncoder(NoOpPasswordEncoder.getInstance());
	 * 
	 * }
	 */
	
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*
		 * InMemoryUserDetailsManager detailsManager= new InMemoryUserDetailsManager();
		 * 
		 * UserDetails user1 =
		 * User.withUsername("Ansar").password("ansar123").authorities("admin").build();
		 * UserDetails user2 =
		 * User.withUsername("Lubna").password("lubna123").authorities("user").build();
		 * 
		 * detailsManager.createUser(user1); detailsManager.createUser(user2);
		 */
		
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		
		
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	
	
	
	

	
	
	

}
