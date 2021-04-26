package com.tfg.cloudlab.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.tfg.cloudlab.dto.TipoSensorDTO;
import com.tfg.cloudlab.modelo.SensorTypeEntity;

@Mapper(componentModel = "spring")
public interface TipoSensorMapper {

	TipoSensorDTO entityToDto(SensorTypeEntity entity);

	SensorTypeEntity dtoToEntity(TipoSensorDTO dto);

	List<TipoSensorDTO> entitiesToDto(List<SensorTypeEntity> entity);

	List<SensorTypeEntity> dtosToEntities(List<TipoSensorDTO> dto);
}
