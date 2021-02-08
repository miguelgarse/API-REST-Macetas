package com.tfg.maceteros.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfg.maceteros.dto.TipoSensorDTO;
import com.tfg.maceteros.mappers.TipoSensorMapper;
import com.tfg.maceteros.modelo.TipoSensor;
import com.tfg.maceteros.modelo.dao.TipoSensorDao;
import com.tfg.maceteros.service.ITipoSensorService;

@Service
public class TipoSensorServiceImpl implements ITipoSensorService {

@Autowired
private TipoSensorDao tipoSensorDao;
@Autowired
private TipoSensorMapper tipoSensorMapper;

    public List<TipoSensorDTO> listarTipoSensor() {

        List<TipoSensor> tipoSensor = (List<TipoSensor>) tipoSensorDao.findAll();
        return tipoSensorMapper.entitiesToDto(tipoSensor);
    }

    public TipoSensorDTO buscarTipoSensor(String identificador){
         Optional<TipoSensor> tipoSensor = tipoSensorDao.findById(Long.parseLong(identificador));
         return tipoSensor.isPresent() ? tipoSensorMapper.entityToDto(tipoSensor.get()) :  null;
    }


}
