package com.aurionpro.security.Filter;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.AllArgsConstructor;
import lombok.Data;

import com.aurionpro.entity.User;
import com.aurionpro.security.SecurityConstants;
import com.aurionpro.security.manager.CustomAuthenticationManager;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import com.fasterxml.jackson.databind.ObjectMapper;

@Data
@AllArgsConstructor
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	@Autowired
	CustomAuthenticationManager authenticationManager;

	public AuthenticationFilter(CustomAuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		try {
			User user = new ObjectMapper().readValue(request.getInputStream(), User.class);
			Authentication authentication = new UsernamePasswordAuthenticationToken(user.getUsername(),
					user.getPassword());
			System.out.println(user.getUsername());
			System.out.println(user.getPassword());
			return authenticationManager.authenticate(authentication);

		} catch (IOException e) {
			throw new RuntimeException();
		}

//		return super.attemptAuthentication(request, response);
	}


	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.getWriter().write(failed.getMessage());
		response.getWriter().flush();
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		System.out.println("Wohoo,Success....");
//		System.out.println(authResult);
		
		List<String> rolesList = authResult.getAuthorities().parallelStream().map(x->x.getAuthority()).collect(Collectors.toList());
		String roleNames = String.join(",", rolesList);
		System.out.println(authResult.getAuthorities());
		String token = JWT.create().withSubject(authResult.getName())
				.withClaim("roles", roleNames)
				.withExpiresAt(new Date(System.currentTimeMillis() + SecurityConstants.TOKEN_EXPIRATION))
				.sign(Algorithm.HMAC512(SecurityConstants.SECRET_KEY));
		response.addHeader(SecurityConstants.AUTHORIZATION, SecurityConstants.BEARER + token);
	}

}