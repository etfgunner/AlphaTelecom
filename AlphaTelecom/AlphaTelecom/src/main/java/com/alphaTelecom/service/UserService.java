package com.alphaTelecom.service;

import com.alphaTelecom.model.User;

public interface UserService {
	public User findUserByUsername(String username);
	public User saveUser(User user);
}