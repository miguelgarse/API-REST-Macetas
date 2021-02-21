package com.tfg.cloudlab.modelo.dao;

import org.springframework.stereotype.Repository;

import com.tfg.cloudlab.modelo.Events;

import java.util.List;

@Repository
public interface EventsDaoCustom {
    List<Events> findByActionDesc(String desc, Long client);
}
