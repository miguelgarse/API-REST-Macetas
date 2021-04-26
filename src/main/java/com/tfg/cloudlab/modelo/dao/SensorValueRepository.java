package com.tfg.cloudlab.modelo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tfg.cloudlab.modelo.SensorValueEntity;

@Repository
public interface SensorValueRepository extends JpaRepository<SensorValueEntity, Long> {


}
