package com.tfg.cloudlab.modelo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tfg.cloudlab.modelo.Cliente;
import com.tfg.cloudlab.modelo.Events;

@Repository
public interface EventsDao extends CrudRepository<Events, Long>, EventsDaoCustom {
}
