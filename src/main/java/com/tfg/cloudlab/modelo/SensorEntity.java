package com.tfg.cloudlab.modelo;

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
@Table(name = "SENSOR")
public class SensorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@ManyToOne(cascade = CascadeType.ALL)
	private SensorTypeEntity sensorType;

	@ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
	private User createdUser;

	@ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
	private User lastModifieduser;

	@Temporal(TemporalType.DATE)
	private Date dateCreated;

	@Temporal(TemporalType.DATE)
	private Date dateLastModified;

	public SensorEntity() {
		// Empty constructor
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SensorTypeEntity getSensorType() {
		return sensorType;
	}

	public void setSensorType(SensorTypeEntity sensorType) {
		this.sensorType = sensorType;
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

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateLastModified() {
		return dateLastModified;
	}

	public void setDateLastModified(Date dateLastModified) {
		this.dateLastModified = dateLastModified;
	}

}
