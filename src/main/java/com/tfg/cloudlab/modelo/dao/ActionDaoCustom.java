package com.tfg.cloudlab.modelo.dao;

import org.springframework.stereotype.Repository;

import com.tfg.cloudlab.modelo.Actions;

@Repository
public interface ActionDaoCustom {

    Actions findByDesc(String desc);
}
