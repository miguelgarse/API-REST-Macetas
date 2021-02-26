package com.tfg.cloudlab.modelo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tfg.cloudlab.modelo.Sensor;
import com.tfg.cloudlab.modelo.Timeline;

import java.util.List;

@Repository
public interface TimeLineDao extends CrudRepository<Timeline, Long>,TimeLineDaoCustom {

    List<Timeline> findBySensor(Sensor a);
    List<Timeline> findBySensorOrder(Sensor a);


}
