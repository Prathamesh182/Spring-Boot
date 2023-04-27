package com.aurionpro.security.manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.aurionpro.entity.User;
import com.aurionpro.security.GrantedAuthorityImpl;
import com.aurionpro.service.UserService;

@Component
public class CustomAuthenticationManager implements AuthenticationManager {

	
	@Autowired
	private UserService service;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		User user = service.getUser(authentication.getName());
//		System.out.println(user.getRoles());
		List<String> roles = user.getRoles().stream().map(x->x.getName()).collect(Collectors.toList());
//		System.out.println(roles);
		if (!bCryptPasswordEncoder.matches(authentication.getCredentials().toString(), user.getPassword())) {
			throw new BadCredentialsException("You provided an incorrect password.");
		}

		return new UsernamePasswordAuthenticationToken(authentication.getName(), user.getPassword(),setUserAuthorities(roles));
	}
	
	public Collection<GrantedAuthority> setUserAuthorities(List<String> auths) {

		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		for (String auth : auths)
			grantedAuthorities.add(new GrantedAuthorityImpl(auth));
		System.out.println("Hello "+ grantedAuthorities);
		return grantedAuthorities;
	}

}