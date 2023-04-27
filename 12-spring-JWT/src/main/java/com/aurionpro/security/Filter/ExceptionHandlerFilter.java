package com.aurionpro.security.Filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class ExceptionHandlerFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		System.out.println("Inside Filter chain");
		try {
			filterChain.doFilter(request, response);
		} catch (RuntimeException e) {
			e.printStackTrace();
//			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//			response.getWriter().write("BAD REQUEST"); // <--
//			response.getWriter().flush();
		}

	}

}