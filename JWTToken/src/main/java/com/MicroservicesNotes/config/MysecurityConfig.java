package com.MicroservicesNotes.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.MicroservicesNotes.service.CustomuserDetailServices;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class MysecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomuserDetailServices customUserDetailService;
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		super.configure(http);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	   auth.userDetailsService(customUserDetailService);
	}
	
	
	

}
