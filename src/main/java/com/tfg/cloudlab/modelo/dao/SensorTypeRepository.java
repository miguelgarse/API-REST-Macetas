package com.tfg.cloudlab.modelo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tfg.cloudlab.modelo.SensorTypeEntity;


@Repository
public interface SensorTypeRepository extends JpaRepository<SensorTypeEntity, Long> {

	SensorTypeEntity findByName(String name);
	
}
