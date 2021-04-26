package com.tfg.cloudlab.modelo.dao;

import org.springframework.stereotype.Repository;

import com.tfg.cloudlab.modelo.SensorTypeEntity;

@Repository
public interface TipoSensorDaoCustom {

	SensorTypeEntity findByName(String name);
	
}
