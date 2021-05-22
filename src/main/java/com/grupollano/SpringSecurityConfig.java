package com.grupollano;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/bingo/v1/bingo_board")
		.permitAll().antMatchers("/bingo_board")
		.hasAnyRole("Admin").anyRequest()
		.authenticated()
		.and()
			.formLogin()
			.permitAll()
		.and()
			.logout()
			.permitAll();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	public void configureGeneric(AuthenticationManagerBuilder builder) throws Exception {
		PasswordEncoder encoder = passwordEncoder();
		UserBuilder users = org.springframework.security.core.userdetails.User.builder().passwordEncoder(encoder::encode);
		//builder.inMemoryAuthentication().withUser(users.username("admin").roles("Admin", "User"));
		
		builder.inMemoryAuthentication()
		.withUser(users.username("admin").password("123").roles("ADMIN","USER"))
		.withUser(users.username("oscar").password("123").roles("USER"));
	}
	
}
