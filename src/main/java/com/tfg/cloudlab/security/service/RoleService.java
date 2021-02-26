package com.tfg.cloudlab.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tfg.cloudlab.security.entity.Role;
import com.tfg.cloudlab.security.enums.RoleName;
import com.tfg.cloudlab.security.repository.RoleRepository;

@Service
@Transactional
public class RoleService {

	@Autowired
	RoleRepository roleRepository;

	public Optional<Role> getByRoleName(RoleName roleNombre) {
		return roleRepository.findByRoleName(roleNombre);
	}
}
