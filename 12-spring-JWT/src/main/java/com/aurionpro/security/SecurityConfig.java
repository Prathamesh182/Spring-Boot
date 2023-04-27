package com.aurionpro.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.aurionpro.security.Filter.AuthenticationFilter;
import com.aurionpro.security.Filter.ExceptionHandlerFilter;
import com.aurionpro.security.Filter.JWTAuthorizationFilter;
import com.aurionpro.security.manager.CustomAuthenticationManager;


import org.springframework.security.config.http.SessionCreationPolicy;


@Configuration
public class SecurityConfig {

	@Autowired
	CustomAuthenticationManager authenticationManager;
	
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        AuthenticationFilter authenticateFilter=new AuthenticationFilter(authenticationManager);
        authenticateFilter.setFilterProcessesUrl("/authenticate");
    	
    	http        
            .csrf().disable()
            .authorizeRequests()
            .antMatchers(HttpMethod.POST,SecurityConstants.REGISTER_USER_PATH).permitAll()
            .anyRequest().authenticated()
            .and()
            .addFilterBefore(new ExceptionHandlerFilter(), AuthenticationFilter.class)
            .addFilter(authenticateFilter)
            .addFilterAfter(new JWTAuthorizationFilter(), AuthenticationFilter.class)
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        return http.build();
    }
    
}