package com.tfg.cloudlab.mappers;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.tfg.cloudlab.dto.SensorDTO;
import com.tfg.cloudlab.dto.Sensor_ClienteDTO;
import com.tfg.cloudlab.modelo.Sensor;
import com.tfg.cloudlab.modelo.Sensor_Cliente;

@Mapper(componentModel = "spring",uses = TipoSensorMapper.class)
public interface SensorMapper {

    @Mapping(target = "tipoSensorId", source = "tipoSensor.nombre")
    SensorDTO entityToDto(Sensor entity);
    @InheritInverseConfiguration
    Sensor dtoToEntity(SensorDTO dto);
    List<SensorDTO> entitiesToDto(List<Sensor> entity);
    List<Sensor> dtosToEntities(List<SensorDTO> dto);
}
