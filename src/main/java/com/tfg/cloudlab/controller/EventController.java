package com.tfg.cloudlab.controller;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tfg.cloudlab.dto.EventsDTO;
import com.tfg.cloudlab.service.IEnventosService;

@RestController
@RequestMapping(value = "/api/event")
public class EventController {

	@Autowired
	private IEnventosService service;

	@PutMapping(value = "/{action}/{client_id}")
	public EventsDTO registrarEvento(@NotNull @NotEmpty @PathVariable(value = "client_id") String idThingsboard,
			@NotNull @NotEmpty @PathVariable(value = "action") String accion) {
		return service.registrarEvento(accion, idThingsboard);
	}
}
