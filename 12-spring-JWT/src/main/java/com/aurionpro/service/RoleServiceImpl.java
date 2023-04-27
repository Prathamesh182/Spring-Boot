package com.aurionpro.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	com.aurionpro.repository.RoleRepository roleRepository;
	
	@Override
	public com.aurionpro.entity.Role saveRole(com.aurionpro.entity.Role role) {
		return roleRepository.save(role);
	}

}