package com.tfg.maceteros.service;

import org.springframework.stereotype.Service;

import com.tfg.maceteros.modelo.Usuario;

@Service
public interface IUsersServices {
	public Usuario login(String user, String pass);
	
	public Usuario register(Usuario user);
}
