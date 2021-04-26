package com.tfg.cloudlab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tfg.cloudlab.dto.SensorDto;
import com.tfg.cloudlab.service.impl.SensorValueService;

@RestController
@RequestMapping(value = "/api/timeLine")
public class SensorValueController {
	
	private SensorValueService sensorValueService;
	
	@Autowired
	public SensorValueController(SensorValueService sensorValueService) {
		this.sensorValueService = sensorValueService;
	}
	
	@GetMapping(value = "/{sensor_id}")
	public List<SensorDto> valoresSensor(@PathVariable(value = "sensor_id") String sensorId) {
		return sensorValueService.valoresSensor(sensorId);
	}

}
