package com.tfg.cloudlab.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tfg.cloudlab.security.entity.Role;
import com.tfg.cloudlab.security.enums.RoleName;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	Optional<Role> findByRoleName(RoleName roleNombre);
}
