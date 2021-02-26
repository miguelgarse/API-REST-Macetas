package com.tfg.cloudlab.modelo.dao;

import org.springframework.stereotype.Repository;

import com.tfg.cloudlab.modelo.Cliente;


@Repository
public interface ClienteDaoCustom {

	Cliente findByThingsBoard(String a);
}
