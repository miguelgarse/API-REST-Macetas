package com.tfg.maceteros.service;

import org.springframework.stereotype.Service;

import com.tfg.maceteros.modelo.User;

@Service
public interface IUsersServices {
	public User login(String user, String pass);
	
	public User register(User user);
}
