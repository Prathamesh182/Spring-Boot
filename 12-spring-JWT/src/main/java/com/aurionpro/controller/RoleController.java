package com.aurionpro.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.entity.Role;
import com.aurionpro.service.RoleService;

@RestController
@RequestMapping("/roles")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@PostMapping("/addrole")
	public ResponseEntity<Role> createUser(@Valid @RequestBody Role role) {
		return new ResponseEntity<>(roleService.saveRole(role), HttpStatus.CREATED);
	}
}