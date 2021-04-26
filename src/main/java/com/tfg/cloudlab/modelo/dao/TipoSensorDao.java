package com.tfg.cloudlab.modelo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tfg.cloudlab.modelo.SensorTypeEntity;


@Repository
public interface TipoSensorDao extends CrudRepository<SensorTypeEntity, Long>, TipoSensorDaoCustom {

}
