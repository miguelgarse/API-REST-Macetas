package com.tfg.cloudlab.modelo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tfg.cloudlab.modelo.Sensor_Cliente;

@Repository
public interface SensorClienteDao extends CrudRepository<Sensor_Cliente, Long>, SensorClienteDaoCustom {

}
