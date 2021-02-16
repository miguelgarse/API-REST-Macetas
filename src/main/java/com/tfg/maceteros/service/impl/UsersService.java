package com.tfg.maceteros.service.impl;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfg.maceteros.modelo.User;
import com.tfg.maceteros.modelo.dao.UsuarioDao;
import com.tfg.maceteros.service.IUsersServices;

@Service
public class UsersService implements IUsersServices {

    @Autowired
    private UsuarioDao usuarioDao;

    public User login(String usuario, String pass) {
        List<User> usuarios = (ArrayList<User>) usuarioDao.findAll();
        String passCod = Base64.getEncoder().encodeToString(pass.getBytes());
        for (User user : usuarios) {
            if (user.getUsername().equals(usuario) && user.getPassword().equals(passCod)) {
                return user;
            }
        }
        return new User();
    }
    
	@Override
	public User register(User user) {
		// TODO Auto-generated method stub
		return null;
	}
}
