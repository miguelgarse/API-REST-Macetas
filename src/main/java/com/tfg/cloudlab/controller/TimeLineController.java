package com.tfg.cloudlab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tfg.cloudlab.dto.TimeLineDTO;
import com.tfg.cloudlab.dto.ValoresangularDTO;
import com.tfg.cloudlab.service.ITimeLineService;

@RestController
@RequestMapping(value = "/api/timeLine")
public class TimeLineController {

	@Autowired
	private ITimeLineService service;

	@GetMapping(value = "/{sensor_id}")
	public List<TimeLineDTO> valoresSensor(
			@PathVariable(value = "sensor_id") String sensorId) {
		return service.valoresSensor(sensorId);
	}

	@GetMapping(value = "all")
	public List<ValoresangularDTO> valoresCliente() {
		return service.valoresCliente();
	}
}
