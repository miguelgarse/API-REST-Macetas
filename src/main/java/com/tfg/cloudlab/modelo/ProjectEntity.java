package com.tfg.cloudlab.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;

import com.tfg.cloudlab.dto.ProjectDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "PROJECT")
public class ProjectEntity {

	@Id
	private Long id;
	private String title;
	private String description;
	private String keywords;
	private String location;

	public ProjectEntity() {
		// Empty constructor
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public ProjectEntity(ProjectDto project) {
		BeanUtils.copyProperties(project, this);
	}

	public ProjectDto toProjectDto() {
		ProjectDto project = new ProjectDto();
		BeanUtils.copyProperties(this, project);
		return project;
	}

}
