package com.tfg.cloudlab.modelo.dao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tfg.cloudlab.modelo.Sensor;
@Repository
public interface SensorDao extends CrudRepository<Sensor, Long>, SensorDaoCustom {
	
}
