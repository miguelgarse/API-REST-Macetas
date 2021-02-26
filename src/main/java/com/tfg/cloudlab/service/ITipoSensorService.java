package com.tfg.cloudlab.service;

import org.springframework.stereotype.Service;

import com.tfg.cloudlab.dto.TipoSensorDTO;

import java.util.List;
@Service
public interface ITipoSensorService {
    List<TipoSensorDTO> listarTipoSensor();
    TipoSensorDTO buscarTipoSensor(String identificador);;
}
