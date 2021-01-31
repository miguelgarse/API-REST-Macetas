package com.tfg.maceteros.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tfg.maceteros.dto.EventsDTO;
import com.tfg.maceteros.dto.TimeLineDTO;

@Service
public interface IServicio {
	List<TimeLineDTO> persisitirDatos(String device, String idThingsboard);

	String recogerConfiguracion(String device);

	List<EventsDTO> riego(String cliente);
}
