package com.tfg.cloudlab.modelo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tfg.cloudlab.modelo.Actions;

@Repository
public interface ActionDao extends CrudRepository<Actions, Long>, ActionDaoCustom {
}
