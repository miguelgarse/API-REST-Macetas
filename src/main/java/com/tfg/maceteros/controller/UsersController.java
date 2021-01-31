package com.tfg.maceteros.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tfg.maceteros.modelo.Usuario;
import com.tfg.maceteros.service.IUsersServices;

@RestController
@RequestMapping(value = "/users")
public class UsersController {

	@Autowired
    private IUsersServices userService;

    @GetMapping(value = "/login")
    public Usuario login(@RequestParam String user, @RequestParam String pass) {
        return userService.login(user, pass);
    }
    
}
