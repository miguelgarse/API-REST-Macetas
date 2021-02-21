package com.tfg.cloudlab.mappers;

import org.mapstruct.Mapper;

import com.tfg.cloudlab.dto.ClienteDTO;
import com.tfg.cloudlab.dto.EventsDTO;
import com.tfg.cloudlab.modelo.Cliente;
import com.tfg.cloudlab.modelo.Events;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventsMapper {
    EventsDTO entityToDto(Events entity);
    Events dtoToEntity(EventsDTO dto);
    List<EventsDTO> entitiesToDto(List<Events> entity);
    List<Events> dtosToEntities(List<EventsDTO> dto);
}
