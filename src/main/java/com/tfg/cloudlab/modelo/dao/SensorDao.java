package com.tfg.cloudlab.modelo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tfg.cloudlab.modelo.SensorEntity;


@Repository
public interface SensorDao extends CrudRepository<SensorEntity, Long>, SensorDaoCustom {

}
