package com.tfg.cloudlab.modelo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.tfg.cloudlab.modelo.SensorTypeEntity;

@Repository
public class TipoSensorDaoCustomImpl implements TipoSensorDaoCustom {
	
	@PersistenceContext
	private EntityManager entityManager;

	public SensorTypeEntity findByName(String name) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<SensorTypeEntity> query = cb.createQuery(SensorTypeEntity.class);
		Root<SensorTypeEntity> tipoSensor = query.from(SensorTypeEntity.class);
		query.select(tipoSensor).where(tipoSensor.get("name").in(name));
		return entityManager.createQuery(query).getSingleResult();
	}
}
