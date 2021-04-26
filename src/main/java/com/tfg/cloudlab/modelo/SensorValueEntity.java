package com.tfg.cloudlab.modelo;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.tfg.cloudlab.security.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "SENSOR_VALUE")
public class SensorValueEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private BigDecimal valor;

	private Date timestamp;

	@ManyToOne(cascade = CascadeType.ALL)
	private SensorEntity sensor;

	@ManyToOne(targetEntity = ProjectEntity.class, fetch = FetchType.LAZY)
	private ProjectEntity project;
	
	@ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
	private User createdUser;

	@ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
	private User lastModifieduser;

	@Temporal(TemporalType.DATE)
	private Date dateCreated;

	@Temporal(TemporalType.DATE)
	private Date dateLastModified;

	public SensorValueEntity() {
		// Empty constructor
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public SensorEntity getSensor() {
		return sensor;
	}

	public void setSensor(SensorEntity sensor) {
		this.sensor = sensor;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public User getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(User createdUser) {
		this.createdUser = createdUser;
	}

	public User getLastModifieduser() {
		return lastModifieduser;
	}

	public void setLastModifieduser(User lastModifieduser) {
		this.lastModifieduser = lastModifieduser;
	}

	public Date getDateLastModified() {
		return dateLastModified;
	}

	public void setDateLastModified(Date dateLastModified) {
		this.dateLastModified = dateLastModified;
	}

	public ProjectEntity getProject() {
		return project;
	}

	public void setProject(ProjectEntity project) {
		this.project = project;
	}

}
