package com.tfg.maceteros.controller;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tfg.maceteros.dto.TipoSensorDTO;
import com.tfg.maceteros.service.ITipoSensorService;

@RestController
@RequestMapping(value = "/api/tipoSensor")
public class TipoSensorController {
	@Autowired
	private ITipoSensorService service;

	@GetMapping(value = "")
	public List<TipoSensorDTO> listarTipoSensor() {
		return service.listarTipoSensor();
	}

	@GetMapping(value = "/{tipoSensor_id}")
	public TipoSensorDTO buscarTipoSensor(
			@NotNull @NotEmpty @PathVariable(value = "tipoSensor_id") String tipoSensorId) {
		return service.buscarTipoSensor(tipoSensorId);
	}
}
