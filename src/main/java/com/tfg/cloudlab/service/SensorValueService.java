package com.tfg.cloudlab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfg.cloudlab.dto.SensorDto;
import com.tfg.cloudlab.modelo.dao.SensorRepository;
import com.tfg.cloudlab.modelo.dao.SensorValueRepository;

@Service
public class SensorValueService {
	
	private SensorRepository sensorRepository;
	
	private SensorValueRepository sensorValueRepository;
	
	@Autowired
	public SensorValueService(SensorRepository sensorRepository, SensorValueRepository sensorValueRepository) {
		this.sensorRepository = sensorRepository;
		this.sensorValueRepository = sensorValueRepository;
	}

	public List<SensorDto> findAllSensorValueBySensorId(String sensorId) {
		// Empty service
		return null;
	}

}
