package com.grupollano;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.grupollano.security.UsuarioDetailServices;
import com.grupollano.security.jwt.JWTAuthenticationFilter;
import com.grupollano.security.jwt.JWTAuthorizationFilter;
import com.grupollano.security.jwt.services.JWTService;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("UsuarioDetailServices")
	private UsuarioDetailServices userDeatilServices;

	@Autowired
	private BCryptPasswordEncoder passEcoder;
	
	@Autowired
	private JWTService jwtService;


	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/","/bingo/v1/login", "/bingo/v1/bingo_board",  "/bingo/v1/bingo_figura","bingo/v1/bingo_winner").permitAll()
				.anyRequest().authenticated()
			
				.and()
				.addFilter(new JWTAuthenticationFilter(authenticationManager(),jwtService))
				.addFilter(new JWTAuthorizationFilter(authenticationManager(),jwtService))
				.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	public void configureGeneric(AuthenticationManagerBuilder builder) throws Exception {

		builder.userDetailsService(userDeatilServices).passwordEncoder(passEcoder);
	}

}
