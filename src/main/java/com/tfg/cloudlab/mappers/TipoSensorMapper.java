package com.tfg.cloudlab.mappers;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;

import com.tfg.cloudlab.dto.TimeLineDTO;
import com.tfg.cloudlab.dto.TipoSensorDTO;
import com.tfg.cloudlab.modelo.Timeline;
import com.tfg.cloudlab.modelo.TipoSensor;

@Mapper(componentModel = "spring")
public interface TipoSensorMapper {

    TipoSensorDTO entityToDto(TipoSensor entity);
    TipoSensor dtoToEntity(TipoSensorDTO dto);
    List<TipoSensorDTO> entitiesToDto(List<TipoSensor> entity);
    List<TipoSensor> dtosToEntities(List<TipoSensorDTO> dto);
}
