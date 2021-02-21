package com.tfg.cloudlab.modelo.dao;


import org.springframework.stereotype.Repository;

import com.tfg.cloudlab.modelo.TipoSensor;
@Repository
public interface TipoSensorDaoCustom {

	TipoSensor findByNombre(String i);
}
