package com.tfg.cloudlab.dto;

import java.util.Date;

import com.tfg.cloudlab.modelo.Actions;
import com.tfg.cloudlab.modelo.Cliente;

public class EventsDTO  {

    private Long id;
    private Date timestamp;
    private Cliente cliente;
    private Actions action;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Actions getAction() {
        return action;
    }

    public void setAction(Actions action) {
        this.action = action;
    }
}
