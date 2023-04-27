package com.aurionpro.service;

import com.aurionpro.entity.User;

public interface UserService {
    User getUser(Long id);
    User getUser(String userName);
	User saveUser(User user);
	User addRoleToUser(Long userid, Integer roleid);
}