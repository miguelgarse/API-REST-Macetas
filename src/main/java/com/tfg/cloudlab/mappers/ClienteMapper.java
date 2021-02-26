package com.tfg.cloudlab.mappers;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Configuration;

import com.tfg.cloudlab.dto.ClienteDTO;
import com.tfg.cloudlab.modelo.Cliente;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
	ClienteDTO entityToDto(Cliente entity);
	Cliente dtoToEntity(ClienteDTO dto);
	List<ClienteDTO> entitiesToDto(List<Cliente> entity);
	List<Cliente> dtosToEntities(List<ClienteDTO> dto);
}
