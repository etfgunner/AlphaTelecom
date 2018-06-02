package com.onlineCompetitionSystem.service;

import com.onlineCompetitionSystem.model.User;

public interface UserService {
	public User findUserByUsername(String username);
	public User saveUser(User user);
}