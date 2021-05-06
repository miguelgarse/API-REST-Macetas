package com.tfg.cloudlab.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfg.cloudlab.dto.SensorTypeDto;
import com.tfg.cloudlab.modelo.SensorTypeEntity;
import com.tfg.cloudlab.modelo.dao.SensorTypeRepository;

@Service
public class SensorTypeService {

	private SensorTypeRepository sensorTypeRepository;
	
	@Autowired
	public SensorTypeService(SensorTypeRepository sensorTypeRepository) {
		this.sensorTypeRepository = sensorTypeRepository;
	}

	public List<SensorTypeDto> findAll() {
		return sensorTypeRepository.findAll()
				.stream()
				.map(SensorTypeEntity::toSensorTypeDto)
				.collect(Collectors.toList());
	}

	public SensorTypeDto findById(String sensorTypeId) {
		Optional<SensorTypeEntity> tipoSensor = sensorTypeRepository.findById(Long.parseLong(sensorTypeId));
		
		return tipoSensor.isPresent() ? tipoSensor.get().toSensorTypeDto() : null;
	}

}
