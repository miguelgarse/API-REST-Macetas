package com.tfg.cloudlab.modelo.dao;

import org.springframework.stereotype.Repository;

import com.tfg.cloudlab.modelo.Sensor_Cliente;

import java.util.List;

@Repository
public interface SensorClienteDaoCustom {

	Sensor_Cliente findBySensor(String a);
	List<Sensor_Cliente> findByCliente(Long a);
	Sensor_Cliente findByClienteSensor(String cliente, String sensor );
	
}
