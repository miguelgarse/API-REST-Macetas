package com.tfg.cloudlab.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.tfg.cloudlab.dto.SensorDto;
import com.tfg.cloudlab.dto.SensorValueDto;
import com.tfg.cloudlab.modelo.SensorValueEntity;

@Mapper(componentModel = "spring", uses = SensorMapper.class)
public interface TimelineMapper {

	SensorValueDto entityToDto(SensorValueEntity entity);

	SensorValueEntity dtoToEntity(SensorValueDto dto);

	List<SensorDto> entitiesToDto(List<SensorValueEntity> entity);

	List<SensorValueEntity> dtosToEntities(List<SensorDto> dto);
}
