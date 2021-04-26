package com.tfg.cloudlab.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tfg.cloudlab.dto.SensorDto;

@Service
public interface ISensorService {

	SensorDto addSensor(SensorDto sensorDTO);

	void borrarSensor(String identificador);

	List<SensorDto> listarSensores();

	SensorDto modificarSensor(SensorDto sensor, String identificador);

	List<SensorDto> listarSensoresCliente(String cliente);

	SensorDto buscarSensor(String sensorId);
}
