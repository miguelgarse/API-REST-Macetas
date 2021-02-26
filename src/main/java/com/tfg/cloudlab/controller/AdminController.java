package com.tfg.cloudlab.controller;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tfg.cloudlab.security.dto.NewUser;
import com.tfg.cloudlab.security.entity.Role;
import com.tfg.cloudlab.security.entity.User;
import com.tfg.cloudlab.security.enums.RoleName;
import com.tfg.cloudlab.security.service.RoleService;
import com.tfg.cloudlab.security.service.UserService;

@CrossOrigin(value = "*")
@RestController
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping(value = "/api/admin")
public class AdminController {

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	UserService userService;
	
	@Autowired
	RoleService roleService;

	
	@PostMapping("/createUser")
	public ResponseEntity<String> createUser(@Valid @RequestBody NewUser newUser, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<>("Campos del usuario erroneos", HttpStatus.BAD_REQUEST);
		} else if(userService.existsByUsername(newUser.getUsername())){
			return new ResponseEntity<>("Nombre ya exsite", HttpStatus.BAD_REQUEST);
		} else if(userService.existsByEmail(newUser.getEmail())){
			return new ResponseEntity<>("Email ya exsite", HttpStatus.BAD_REQUEST);
		} else {
			User user = new User(newUser.getName(), newUser.getUsername(), newUser.getEmail(),
					passwordEncoder.encode(newUser.getPassword()));
			
			Set<Role> roles = new HashSet<>();
			roles.add(roleService.getByRoleName(RoleName.ROLE_USER).get());
			
			if(newUser.getRoles().contains("admin")) {
				roles.add(roleService.getByRoleName(RoleName.ROLE_ADMIN).get());
			}
		
			user.setRoles(roles);
			
			userService.save(user);
			
			return new ResponseEntity<>("Usuario creado", HttpStatus.CREATED);
		}
	}
}
