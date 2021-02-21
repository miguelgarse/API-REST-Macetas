package com.tfg.cloudlab.controller;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tfg.cloudlab.dto.Sensor_ClienteDTO;
import com.tfg.cloudlab.service.ISensorClienteService;

@RestController
@RequestMapping(value = "/api/sensor-client")
public class Sensor_ClientController {

	@Autowired
	private ISensorClienteService service;

	@PutMapping(value = "")
	public Sensor_ClienteDTO añadirSensorCliente(@RequestBody Sensor_ClienteDTO sensor_cliente) {
		return service.añadirSensorCliente(sensor_cliente);
	}

	@PostMapping(value = "/{sensor_client_id}")
	public Sensor_ClienteDTO modificarSensorCliente(@NotNull @NotEmpty @RequestBody Sensor_ClienteDTO sensorCliente,
			@PathVariable("sensor_client_id") String identificador) {
		return service.modificarSensorCliente(sensorCliente, identificador);
	}

	@DeleteMapping(value = "/{sensor_client_id}")
	public void borrarSensorCliente(@PathVariable("sensor_client_id") String identificador) {
		service.borrarSensorCliente(identificador);
	}

	@GetMapping(value = "/{sensor_id}")
	public Sensor_ClienteDTO findSensorCliente(@PathVariable("sensor_id") String identificador) {
		return service.buscarSensorCliente(identificador);
	}
}
