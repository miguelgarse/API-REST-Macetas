package com.tfg.cloudlab.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfg.cloudlab.dto.ProjectDto;
import com.tfg.cloudlab.modelo.ProjectEntity;
import com.tfg.cloudlab.modelo.dao.ProjectRepository;

@Service
public class ProjectService {

	private ProjectRepository projectRepository;

	@Autowired
	public ProjectService(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}

	public ProjectDto newProject(ProjectDto project) {
		ProjectEntity projectEntity = new ProjectEntity(project);
		return projectRepository.save(projectEntity).toProjectDto();
	}

	public ProjectDto updateProject(ProjectDto projectDto) {
		return null;
	}

	public ProjectDto deleteProject(String projectId) {
		return null;
	}

	public ProjectDto searchProject(String projectName) {
		return null;
	}

	public List<ProjectDto> findAll() {
		return projectRepository.findAll()
				.stream()
				.map(ProjectEntity::toProjectDto)
				.collect(Collectors.toList());
	}

}