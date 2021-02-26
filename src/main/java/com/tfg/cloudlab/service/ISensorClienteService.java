package com.tfg.cloudlab.service;

import org.springframework.stereotype.Service;

import com.tfg.cloudlab.dto.ClienteDTO;
import com.tfg.cloudlab.dto.SensorDTO;
import com.tfg.cloudlab.dto.Sensor_ClienteDTO;
import com.tfg.cloudlab.modelo.Sensor_Cliente;

@Service
public interface ISensorClienteService {
    Sensor_ClienteDTO buscarSensorCliente(String identificador);
    void borrarSensorCliente(String identificador);
    Sensor_ClienteDTO añadirSensorCliente(Sensor_ClienteDTO sensor_cliente);
    Sensor_ClienteDTO modificarSensorCliente( Sensor_ClienteDTO sensorCliente,String identificador);
}
