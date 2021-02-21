package com.tfg.cloudlab.service;

import org.springframework.stereotype.Service;

import com.tfg.cloudlab.dto.SensorDTO;

import java.util.List;
@Service
public interface ISensorService {

SensorDTO añadirSensor(SensorDTO sensorDTO);
    void borrarSensor( String identificador);
    List<SensorDTO> listarSensores();
   SensorDTO modificarSensor(SensorDTO sensor, String identificador);
    List<SensorDTO> listarSensoresCliente(String cliente);
    SensorDTO buscarSensor(String sensorId);
}
