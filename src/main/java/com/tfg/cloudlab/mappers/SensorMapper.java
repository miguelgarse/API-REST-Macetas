package com.tfg.cloudlab.mappers;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.tfg.cloudlab.dto.SensorDto;
import com.tfg.cloudlab.modelo.SensorEntity;

@Mapper(componentModel = "spring", uses = TipoSensorMapper.class)
public interface SensorMapper {

	@Mapping(target = "sensorTypeId", source = "sensorType.name")
	SensorDto entityToDto(SensorEntity entity);

	@InheritInverseConfiguration
	SensorEntity dtoToEntity(SensorDto dto);

	List<SensorDto> entitiesToDto(List<SensorEntity> entity);

	List<SensorEntity> dtosToEntities(List<SensorDto> dto);
}
