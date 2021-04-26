package com.tfg.cloudlab.dto;

public class Sensor_ClienteDTO {
	private Long id;
	private SensorDto sensores;
	private ClienteDTO cliente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SensorDto getSensores() {
		return sensores;
	}

	public void setSensores(SensorDto sensores) {
		this.sensores = sensores;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

}
