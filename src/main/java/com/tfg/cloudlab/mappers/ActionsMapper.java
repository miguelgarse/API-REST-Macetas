package com.tfg.cloudlab.mappers;

import org.mapstruct.Mapper;

import com.tfg.cloudlab.dto.ActionsDTO;
import com.tfg.cloudlab.dto.ClienteDTO;
import com.tfg.cloudlab.modelo.Actions;
import com.tfg.cloudlab.modelo.Cliente;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ActionsMapper {

    ActionsDTO entityToDto(Actions entity);
    Actions dtoToEntity(ActionsDTO dto);
    List<ActionsDTO> entitiesToDto(List<Actions> entity);
    List<Actions> dtosToEntities(List<ActionsDTO> dto);
}
