package com.boot.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entity.Users;
import com.boot.repository.UserRepository;
import com.boot.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public void save(Users user) {
		if (user != null) {
			userRepository.save(user);
		}

	}

	@Override
	public Users findByLoginAndPassword(String login, String password) {
		Users user = null;
		if (login != null && password != null) {
			user = userRepository.findByLoginAndPassword(login, password);
		}
		return user;
	}

	@Override
	public Users findByLogin(String login) {
		if (login != null) {
			return userRepository.findByLogin(login);
		}
		return null;
	}

}
