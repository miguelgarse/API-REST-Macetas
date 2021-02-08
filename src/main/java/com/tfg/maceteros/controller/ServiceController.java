package com.tfg.maceteros.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tfg.maceteros.dto.EventsDTO;
import com.tfg.maceteros.dto.TimeLineDTO;
import com.tfg.maceteros.service.IServicio;

@CrossOrigin(value = "*")
@RestController
@RequestMapping(value = "/api")
public class ServiceController {

	@Autowired
	private IServicio service;

	@PostMapping(value = "/persistir")
	public List<TimeLineDTO> persistirDatos(@RequestHeader String device, @RequestHeader String cliente) {
		return service.persisitirDatos(device, cliente);
	}

	@GetMapping(value = "/config/{device_token}")
	public String recogerConfig(@PathVariable(value = "device_token") String device) {
		return service.recogerConfiguracion(device);
	}

	@GetMapping(value = "/irrigation/{client_id}")
	public List<EventsDTO> riego(@PathVariable(value = "client_id") String cliente) {
		return service.riego(cliente);
	}

}
