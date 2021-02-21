package com.tfg.cloudlab.mappers;
import org.mapstruct.Mapper;

import com.tfg.cloudlab.dto.ClienteDTO;
import com.tfg.cloudlab.dto.Sensor_ClienteDTO;
import com.tfg.cloudlab.modelo.Cliente;
import com.tfg.cloudlab.modelo.Sensor_Cliente;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ClienteMapper.class, SensorMapper.class})
public interface SensorClienteMapper {

    Sensor_ClienteDTO entityToDto(Sensor_Cliente entity);
    Sensor_Cliente dtoToEntity(Sensor_ClienteDTO dto);
    List<Sensor_ClienteDTO> entitiesToDto(List<Sensor_Cliente> entity);
    List<Sensor_Cliente> dtosToEntities(List<Sensor_ClienteDTO> dto);
}
