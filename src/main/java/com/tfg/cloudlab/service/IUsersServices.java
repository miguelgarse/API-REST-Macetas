package com.tfg.cloudlab.service;

import org.springframework.stereotype.Service;

import com.tfg.cloudlab.modelo.User;

@Service
public interface IUsersServices {
	public User login(String user, String pass);
	
	public User register(User user);
}
