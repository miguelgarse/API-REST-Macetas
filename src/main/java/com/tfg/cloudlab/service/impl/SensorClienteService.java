package com.tfg.cloudlab.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfg.cloudlab.dto.Sensor_ClienteDTO;
import com.tfg.cloudlab.mappers.ClienteMapper;
import com.tfg.cloudlab.mappers.SensorClienteMapper;
import com.tfg.cloudlab.mappers.SensorMapper;
import com.tfg.cloudlab.modelo.Cliente;
import com.tfg.cloudlab.modelo.SensorEntity;
import com.tfg.cloudlab.modelo.SensorTypeEntity;
import com.tfg.cloudlab.modelo.Sensor_Cliente;
import com.tfg.cloudlab.modelo.dao.ClienteDao;
import com.tfg.cloudlab.modelo.dao.SensorClienteDao;
import com.tfg.cloudlab.modelo.dao.SensorDao;
import com.tfg.cloudlab.modelo.dao.TipoSensorDao;
import com.tfg.cloudlab.service.ISensorClienteService;

@Service
public class SensorClienteService implements ISensorClienteService {
	@Autowired
	private SensorClienteDao sensorClienteDao;
	@Autowired
	private SensorClienteMapper sensorClienteMapper;
	@Autowired
	private ClienteMapper clienteMapper;
	@Autowired
	private SensorMapper sensorMapper;
	@Autowired
	private ClienteDao clienteDao;
	@Autowired
	private TipoSensorDao tipoSensorDao;
	@Autowired
	private SensorDao sensorDao;

	@Override
	public Sensor_ClienteDTO añadirSensorCliente(Sensor_ClienteDTO sensor_clienteDTO) {
		Sensor_Cliente sensor_cliente = new Sensor_Cliente();
		SensorTypeEntity tipoSensor = tipoSensorDao.findByName(sensor_clienteDTO.getSensores().getSensorTypeId());

		Cliente cliente = clienteDao.findByThingsBoard(sensor_clienteDTO.getCliente().getThingsboardId());
		sensor_cliente.setCliente(cliente);
		SensorEntity sensor = sensorDao.findByName(sensor_clienteDTO.getSensores().getName());
		sensor_cliente.setSensores(sensor);
		sensorClienteDao.save(sensor_cliente);
		return sensorClienteMapper.entityToDto(sensor_cliente);
	}

	public Sensor_ClienteDTO modificarSensorCliente(Sensor_ClienteDTO sensorCliente, String identificador) {
		Optional<Sensor_Cliente> sensorClienteFind = sensorClienteDao.findById(new Long(identificador));
		if (sensorClienteFind.isPresent()) {
			if (!sensorClienteFind.get().getSensores().equals(sensorCliente.getSensores())) {
				sensorClienteFind.get().setSensores(sensorMapper.dtoToEntity(sensorCliente.getSensores()));
			}
			if (!sensorClienteFind.get().getCliente().equals(sensorCliente.getCliente())) {
				sensorClienteFind.get().setCliente(clienteMapper.dtoToEntity(sensorCliente.getCliente()));
			}
		}
		return sensorClienteMapper.entityToDto(sensorClienteDao.save(sensorClienteFind.get()));

	}

	public void borrarSensorCliente(String identificador) {
		sensorClienteDao.deleteById(new Long(identificador));
	}

	public Sensor_ClienteDTO buscarSensorCliente(String identificador) {
		SensorEntity sensor = sensorDao.findByName(identificador);
		return sensorClienteMapper.entityToDto(sensorClienteDao.findBySensor(sensor.getId().toString()));
	}
}
