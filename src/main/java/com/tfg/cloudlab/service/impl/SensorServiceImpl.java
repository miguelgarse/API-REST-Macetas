package com.tfg.cloudlab.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfg.cloudlab.dto.SensorDto;
import com.tfg.cloudlab.mappers.SensorMapper;
import com.tfg.cloudlab.modelo.Cliente;
import com.tfg.cloudlab.modelo.SensorEntity;
import com.tfg.cloudlab.modelo.SensorTypeEntity;
import com.tfg.cloudlab.modelo.Sensor_Cliente;
import com.tfg.cloudlab.modelo.dao.ClienteDao;
import com.tfg.cloudlab.modelo.dao.SensorClienteDao;
import com.tfg.cloudlab.modelo.dao.SensorDao;
import com.tfg.cloudlab.modelo.dao.TipoSensorDao;
import com.tfg.cloudlab.service.ISensorService;

@Service
public class SensorServiceImpl implements ISensorService {

	@Autowired
	private SensorMapper sensorMapper;
	@Autowired
	private SensorDao sensorDao;
	@Autowired
	private ClienteDao clienteDao;
	@Autowired
	private SensorClienteDao sensorClienteDao;
	@Autowired
	private TipoSensorDao tipoSensorDao;

	@Override
	public SensorDto addSensor(SensorDto sensorDTO) {
		SensorTypeEntity tipoSensor = tipoSensorDao.findByName(sensorDTO.getSensorTypeId());
		SensorEntity sensor = new SensorEntity();
		sensor.setName(sensorDTO.getName());
		sensor.setSensorType(tipoSensor);
		return sensorMapper.entityToDto(sensorDao.save(sensor));
	}

	public List<SensorDto> listarSensores() {
		List<SensorEntity> sensores = (List<SensorEntity>) sensorDao.findAll();
		return sensorMapper.entitiesToDto(sensores);
	}

	public SensorDto modificarSensor(SensorDto sensor, String identificador) {
		SensorEntity sensorFind = sensorDao.findByName(identificador);

		if (!sensorFind.getName().equals(sensor.getName())) {
			sensorFind.setName(sensor.getName());
		}
		if (!sensorFind.getSensorType().getName().equals(sensor.getSensorTypeId())) {
			sensorFind.setSensorType(tipoSensorDao.findByName(sensor.getSensorTypeId()));
		}

		sensorDao.save(sensorFind);
		return sensorMapper.entityToDto(sensorFind);
	}

	public SensorDto buscarSensor(String sensorId) {
		Optional<SensorEntity> sensor = sensorDao.findById(Long.parseLong(sensorId));
		return sensorMapper.entityToDto(sensor.get());
	}

	public List<SensorDto> listarSensoresCliente(String cliente) {
		Cliente client = clienteDao.findByThingsBoard(cliente);
		List<SensorDto> sensorDTOS = new ArrayList<>();
		List<Sensor_Cliente> sensorCliente = sensorClienteDao.findByCliente(client.getId());
		for (Sensor_Cliente sensor_cliente : sensorCliente) {
			sensorDTOS.add(sensorMapper.entityToDto(sensor_cliente.getSensores()));
		}
		return sensorDTOS;
	}

	public void borrarSensor(String identificador) {
		SensorEntity sensorFind = sensorDao.findByName(identificador);
		sensorDao.deleteById(sensorFind.getId());
	}
}
