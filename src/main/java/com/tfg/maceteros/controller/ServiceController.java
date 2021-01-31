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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

@CrossOrigin(value = "*")
@RestController
@RequestMapping(value = "/api")
@Api(tags = "Configuración Controller")
public class ServiceController {

    @Autowired
    private IServicio service;

    @PostMapping(value = "/persistir")
    @ApiOperation(value = "Operación para persistir todos los datos de un dispositvo", hidden = true)
    @ApiIgnore
    public List<TimeLineDTO> persistirDatos(@RequestHeader @ApiParam(value = "Identificador del dispositivo (Thingsboard)") String device, @RequestHeader @ApiParam(value = "Identificador del cliente (Thingsboard)") String cliente) {
        return service.persisitirDatos(device, cliente);
    }

    @GetMapping(value = "/config/{device_token}")
    @ApiOperation(value = "Operación para recuperar los datos de configuracion del dispositvo")
    public String recogerConfig(@PathVariable(value = "device_token") @ApiParam(value = "Identificador del dispositivo (Thingsboard Token)") String device) {
        return service.recogerConfiguracion(device);
    }

    @GetMapping(value = "/irrigation/{client_id}")
    @ApiOperation(value = "Operación para recuperar el historial de riego")
    public List<EventsDTO> riego(@PathVariable(value = "client_id") @ApiParam(value = "Identificador del cliente (Thingsboard)") String cliente) {
        return service.riego(cliente);
    }

}
