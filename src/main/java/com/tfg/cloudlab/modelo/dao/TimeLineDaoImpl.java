package com.tfg.cloudlab.modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.tfg.cloudlab.modelo.SensorValueEntity;

@Repository
public class TimeLineDaoImpl {

	@PersistenceContext
	private EntityManager entityManager;

	public List<SensorValueEntity> findBySensor(SensorValueEntity a) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<SensorValueEntity> query = cb.createQuery(SensorValueEntity.class);
		Root<SensorValueEntity> timeline = query.from(SensorValueEntity.class);
		query.select(timeline).where(timeline.get("sensor").in(a));
		return entityManager.createQuery(query).setMaxResults(100).getResultList();
	}

	public List<SensorValueEntity> findBySensorOrder(SensorValueEntity a) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<SensorValueEntity> query = cb.createQuery(SensorValueEntity.class);
		Root<SensorValueEntity> timeline = query.from(SensorValueEntity.class);
		query.select(timeline).where(timeline.get("sensor").in(a)).orderBy(cb.desc(timeline.get("timestamp")));
		return entityManager.createQuery(query).setMaxResults(100).getResultList();
	}
}
