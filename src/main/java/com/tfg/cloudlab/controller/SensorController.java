package com.tfg.cloudlab.controller;

import java.util.List;

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

import com.tfg.cloudlab.dto.SensorDTO;
import com.tfg.cloudlab.service.ISensorService;

@RestController
@RequestMapping(value = "/api/sensors")
public class SensorController {

    @Autowired
    private ISensorService service;

    @PutMapping(value = "")
    public SensorDTO añadirSensor(
            @NotNull @NotEmpty @RequestBody SensorDTO sensor) {
        return service.añadirSensor(sensor);
    }

    @PostMapping(value = "/{sensor_id}")
    public SensorDTO modificarSensor(@NotNull @NotEmpty @RequestBody SensorDTO sensor, @PathVariable("sensor_id") String identificador) {
        return service.modificarSensor(sensor,identificador);
    }

    @DeleteMapping(value = "/{sensor_id}")
    public void borrarSensor( @PathVariable("sensor_id") String identificador) {
         service.borrarSensor(identificador);
    }

    @GetMapping(value = "")
    public List<SensorDTO> listarSensores() {
        return service.listarSensores();
    }

    @GetMapping(value = "/{sensor_id}")
    public SensorDTO buscarSensor(@PathVariable(value = "sensor_id") String sensor_id ) {
        return service.buscarSensor(sensor_id);
    }

    @GetMapping(value = "/client/{cliente_id}")
    public List<SensorDTO> listarSensoresDeCliente(@PathVariable(value = "cliente_id") String idThingsboard ) {
        return service.listarSensoresCliente(idThingsboard);
    }

}
