package com.tfg.cloudlab.modelo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tfg.cloudlab.modelo.SensorEntity;

@Repository
public interface SensorDaoCustom {

	List<SensorEntity> findByTipoSensor(String i);

	SensorEntity findByName(String a);

}
