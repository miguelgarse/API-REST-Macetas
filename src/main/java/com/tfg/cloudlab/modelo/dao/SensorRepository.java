package com.tfg.cloudlab.modelo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tfg.cloudlab.modelo.SensorEntity;


@Repository
public interface SensorRepository extends JpaRepository<SensorEntity, Long> {

	List<SensorEntity> findBySensorType(Long id);

	SensorEntity findByName(String a);
	
}
