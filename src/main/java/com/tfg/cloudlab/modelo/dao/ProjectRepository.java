package com.tfg.cloudlab.modelo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tfg.cloudlab.modelo.ProjectEntity;
import com.tfg.cloudlab.security.entity.User;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {

	List<ProjectEntity> findByCreatedUser(User createdUser);
	
}
