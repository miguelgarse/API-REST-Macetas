package com.tfg.maceteros.dto;

public class Sensor_ClienteDTO {
	private Long id;
	private SensorDTO sensores;
	private ClienteDTO cliente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SensorDTO getSensores() {
		return sensores;
	}

	public void setSensores(SensorDTO sensores) {
		this.sensores = sensores;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

}
