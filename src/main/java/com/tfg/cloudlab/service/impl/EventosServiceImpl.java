package com.tfg.cloudlab.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfg.cloudlab.dto.EventsDTO;
import com.tfg.cloudlab.mappers.EventsMapper;
import com.tfg.cloudlab.modelo.Actions;
import com.tfg.cloudlab.modelo.Cliente;
import com.tfg.cloudlab.modelo.Events;
import com.tfg.cloudlab.modelo.dao.ActionDao;
import com.tfg.cloudlab.modelo.dao.ClienteDao;
import com.tfg.cloudlab.modelo.dao.EventsDao;
import com.tfg.cloudlab.service.IEnventosService;

import java.util.Date;
@Service
public class EventosServiceImpl implements IEnventosService {
     @Autowired
    private EventsDao eventsDao;
    @Autowired
    private ClienteDao clienteDao;
    @Autowired
    private ActionDao actionDao;
    @Autowired
    private EventsMapper eventsMapper;

    public EventsDTO registrarEvento(String actions, String cliente){
        Events evento =  new Events();
        Actions accion = actionDao.findByDesc(actions);
        Cliente client = clienteDao.findByThingsBoard(cliente);
        accion.setActionDesc(actions);
        evento.setAction(accion);
        evento.setCliente(client);
        evento.setTimestamp(new Date());
        eventsDao.save(evento);
        return eventsMapper.entityToDto(evento);
    }
}
