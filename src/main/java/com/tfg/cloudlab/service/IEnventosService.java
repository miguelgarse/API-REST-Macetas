package com.tfg.cloudlab.service;

import org.springframework.stereotype.Service;

import com.tfg.cloudlab.dto.EventsDTO;

@Service
public interface IEnventosService {

    EventsDTO registrarEvento(String accion, String clienteId);
}
