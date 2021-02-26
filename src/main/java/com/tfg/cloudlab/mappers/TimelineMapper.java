package com.tfg.cloudlab.mappers;

import org.mapstruct.Mapper;

import com.tfg.cloudlab.dto.SensorDTO;
import com.tfg.cloudlab.dto.TimeLineDTO;
import com.tfg.cloudlab.modelo.Sensor;
import com.tfg.cloudlab.modelo.Timeline;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring", uses = SensorMapper.class)
public interface TimelineMapper {

    TimeLineDTO entityToDto(Timeline entity);
    Timeline dtoToEntity(TimeLineDTO dto);
    List<TimeLineDTO> entitiesToDto(List<Timeline> entity);
    List<Timeline> dtosToEntities(List<TimeLineDTO> dto);
}
