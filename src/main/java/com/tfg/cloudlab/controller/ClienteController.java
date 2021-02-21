package com.tfg.cloudlab.controller;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tfg.cloudlab.dto.ClienteDTO;
import com.tfg.cloudlab.service.IClienteService;


@CrossOrigin(value = "*")
@RestController
@RequestMapping(value = "/api/client")
public class ClienteController {

	@Autowired
	private IClienteService service;

	@PutMapping(value = "")
	public ClienteDTO añadirCliente(
			@NotNull @NotEmpty @RequestBody ClienteDTO cliente) {
		return service.añadirCliente(cliente);
	}

	@GetMapping(value = "")
	public List<ClienteDTO> listarClientes() {
		return service.listarClientes();
	}

	@GetMapping(value = "/{client_id}")
	public ClienteDTO buscarCliente(@NotNull @NotEmpty @PathVariable(value = "client_id") String clienteId) {
		return service.buscarCliente(clienteId);
	}

	@PostMapping(value = "/{client_id}")
	public ClienteDTO modificarCliente(@NotNull @NotEmpty @RequestBody ClienteDTO cliente,
			@PathVariable("client_id") String identificador) {
		return service.modificarCliente(cliente, identificador);
	}

	@DeleteMapping(value = "/{client_id}")
	public ClienteDTO borrarCliente(@NotNull @NotEmpty @PathVariable(value = "client_id") String clienteId) {
		return service.borrarCliente(clienteId);
	}

	@GetMapping(value = "/sensor/{sensor_id}")
	public ClienteDTO buscarClienteSensor(@NotNull @NotEmpty @PathVariable(value = "sensor_id") String sensorId) {
		return service.buscarPorSensor(sensorId);
	}

}
