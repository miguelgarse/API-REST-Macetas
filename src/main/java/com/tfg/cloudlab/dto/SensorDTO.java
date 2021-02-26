package com.tfg.cloudlab.dto;

public class SensorDTO {

	private Long id;
	private String nombre;
	private String tipoSensorId;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoSensorId() {
		return tipoSensorId;
	}

	public void setTipoSensorId(String tipoSensorId) {
		this.tipoSensorId = tipoSensorId;
	}

}
