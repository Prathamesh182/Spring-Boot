package com.aurionpro.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.entity.User;
import com.aurionpro.service.UserService;



@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
    private UserService userService;

	@GetMapping("/{id}")
	public ResponseEntity<String> findById(@PathVariable Long id) {
		return new ResponseEntity<>(userService.getUser(id).getUsername(), HttpStatus.OK);
	}

    @PostMapping("/register")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		return new ResponseEntity<>(userService.saveUser(user),HttpStatus.CREATED);
	}
    
    @PutMapping("/userid/{userid}/role/{roleid}")
    public ResponseEntity<User> addRoleToUser(@Valid @PathVariable Long userid,@PathVariable Integer roleid) {
		return new ResponseEntity<>(userService.addRoleToUser(userid,roleid),HttpStatus.CREATED);
	}
    
}