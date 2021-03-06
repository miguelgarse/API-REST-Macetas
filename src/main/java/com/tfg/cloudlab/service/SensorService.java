package com.tfg.cloudlab.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfg.cloudlab.dto.SensorDto;
import com.tfg.cloudlab.modelo.SensorEntity;
import com.tfg.cloudlab.modelo.SensorTypeEntity;
import com.tfg.cloudlab.modelo.dao.SensorRepository;
import com.tfg.cloudlab.modelo.dao.SensorTypeRepository;

@Service
public class SensorService {
	
	private SensorRepository sensorRepository;
	
	private SensorTypeRepository sensorTypeRepository;
	
	@Autowired
	public SensorService(SensorRepository sensorRepository, SensorTypeRepository sensorTypeRepository) {
		this.sensorRepository = sensorRepository;
		this.sensorTypeRepository = sensorTypeRepository;
	}

	public SensorDto createSensor(SensorDto sensorDto) {
		SensorTypeEntity tipoSensor = sensorTypeRepository.findByName(sensorDto.getSensorTypeId());
		SensorEntity sensor = new SensorEntity();
		sensor.setName(sensorDto.getName());
		sensor.setSensorType(tipoSensor);
		return sensorRepository.save(sensor).toSensorDto();
	}

	public List<SensorDto> findAll() {
		return sensorRepository.findAll()
				.stream()
				.map(SensorEntity::toSensorDto)
				.collect(Collectors.toList());
	}

	public SensorDto updateSensor(SensorDto sensor, String identificador) {
		SensorEntity sensorToUpdate = sensorRepository.findByName(identificador);

		if (!sensorToUpdate.getName().equals(sensor.getName())) {
			sensorToUpdate.setName(sensor.getName());
		}
		if (!sensorToUpdate.getSensorType().getName().equals(sensor.getSensorTypeId())) {
			sensorToUpdate.setSensorType(sensorTypeRepository.findByName(sensor.getSensorTypeId()));
		}
		
		return sensorRepository.save(sensorToUpdate).toSensorDto();
	}

	public SensorDto findBySensorId(String sensorId) {
		Optional<SensorEntity> sensor = sensorRepository.findById(Long.parseLong(sensorId));
		
		return sensor.isPresent() ? sensor.get().toSensorDto() : null;
	}

	public void deleteSensor(String sensorId) {
		SensorEntity sensorFind = sensorRepository.findByName(sensorId);
		sensorRepository.deleteById(sensorFind.getId());
	}
}
