package com.tfg.cloudlab.service;

import org.springframework.stereotype.Service;

import com.tfg.cloudlab.dto.ClienteDTO;

import java.util.List;
@Service
public interface IClienteService {
    ClienteDTO añadirCliente(ClienteDTO cliente);
    ClienteDTO modificarCliente(ClienteDTO clienteDto, String identificador);
    ClienteDTO borrarCliente(String clienteId);
    ClienteDTO buscarCliente(String identificador);
    ClienteDTO buscarPorSensor(String sensorId);
    List<ClienteDTO> listarClientes();
}
