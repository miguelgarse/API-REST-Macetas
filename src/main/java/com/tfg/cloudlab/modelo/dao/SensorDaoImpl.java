package com.tfg.cloudlab.modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.tfg.cloudlab.modelo.SensorEntity;

@Repository
public class SensorDaoImpl implements SensorDaoCustom {

	@PersistenceContext
	private EntityManager entityManager;

	public List<SensorEntity> findByTipoSensor(String a) {
		Integer i = Integer.parseInt(a);
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<SensorEntity> query = cb.createQuery(SensorEntity.class);
		Root<SensorEntity> sensor = query.from(SensorEntity.class);
		query.select(sensor).where(sensor.get("tipoSensor").in(i));
		return entityManager.createQuery(query).getResultList();
	}

	public SensorEntity findByName(String a) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<SensorEntity> query = cb.createQuery(SensorEntity.class);
		Root<SensorEntity> sensor = query.from(SensorEntity.class);
		query.select(sensor).where(sensor.get("nombre").in(a));
		return entityManager.createQuery(query).getSingleResult();
	}
}
