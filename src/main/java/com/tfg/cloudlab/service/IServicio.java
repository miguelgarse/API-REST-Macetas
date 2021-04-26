package com.tfg.cloudlab.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tfg.cloudlab.dto.EventsDTO;
import com.tfg.cloudlab.dto.SensorValueDto;

@Service
public interface IServicio {
	List<SensorValueDto> persisitirDatos(String device, String idThingsboard);

	String recogerConfiguracion(String device);

	List<EventsDTO> riego(String cliente);
}
