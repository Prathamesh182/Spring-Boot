package com.aurionpro.security.Filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.aurionpro.security.SecurityConstants;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JWTAuthorizationFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String header = request.getHeader("Authorization");

		if (header == null || !header.startsWith(SecurityConstants.BEARER)) {
			filterChain.doFilter(request, response);
			return;
		}

		String token = header.replace(SecurityConstants.BEARER, "");
		DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC512(SecurityConstants.SECRET_KEY)).build().verify(token);

		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		String user = decodedJWT.getSubject();
		List<String> roles = Arrays
				.asList(decodedJWT.getClaim("roles").toString().replace("\"", "").split("\\s*,\\s*"));
		System.out.println(roles);
		if (roles.size() > 1)

			for (String r : roles) {
				authorities.add(new SimpleGrantedAuthority(r));
			}
		System.out.println(authorities);

		Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, authorities);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		filterChain.doFilter(request, response);
	}
}