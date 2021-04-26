package com.tfg.cloudlab.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfg.cloudlab.dto.SensorDto;
import com.tfg.cloudlab.modelo.dao.SensorDao;
import com.tfg.cloudlab.modelo.dao.SensorValueRepository;

@Service
public class SensorValueService {
	
	@Autowired
	private SensorDao sensorDao;
	
	@Autowired
	private SensorValueRepository sensorValueRepository;

	public List<SensorDto> valoresSensor(String sensor_id) {
		// Empty service
		return null;
	}

}
