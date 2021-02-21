package com.tfg.cloudlab.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfg.cloudlab.dto.SensorDTO;
import com.tfg.cloudlab.mappers.SensorMapper;
import com.tfg.cloudlab.modelo.Cliente;
import com.tfg.cloudlab.modelo.Sensor;
import com.tfg.cloudlab.modelo.Sensor_Cliente;
import com.tfg.cloudlab.modelo.TipoSensor;
import com.tfg.cloudlab.modelo.dao.ClienteDao;
import com.tfg.cloudlab.modelo.dao.SensorClienteDao;
import com.tfg.cloudlab.modelo.dao.SensorDao;
import com.tfg.cloudlab.modelo.dao.TipoSensorDao;
import com.tfg.cloudlab.service.ISensorService;
@Service
public class SensorServiceImpl implements ISensorService {

    @Autowired
    private SensorMapper sensorMapper;
    @Autowired
    private SensorDao sensorDao;
    @Autowired
    private ClienteDao  clienteDao;
    @Autowired
    private SensorClienteDao sensorClienteDao;
    @Autowired
    private TipoSensorDao tipoSensorDao;

    @Override
    public SensorDTO añadirSensor(SensorDTO sensorDTO) {
        TipoSensor tipoSensor = tipoSensorDao.findByNombre(sensorDTO.getTipoSensorId());
        Sensor sensor = new Sensor();
        sensor.setNombre(sensorDTO.getNombre());
        sensor.setTipoSensor(tipoSensor);
       return sensorMapper.entityToDto(sensorDao.save(sensor));
    //  List<Sensor> sensorEntity =  (ArrayList<Sensor>) sensorDao.findAll();
      //  return sensorMapper.entityToDto(sensorEntity.get(sensorEntity.size()-1));
    }

    public List<SensorDTO> listarSensores() {
        List<Sensor> sensores = (List<Sensor>) sensorDao.findAll();
        return sensorMapper.entitiesToDto(sensores);
    }

    public SensorDTO modificarSensor(SensorDTO sensor, String identificador){
        Sensor sensorFind = sensorDao.findByName(identificador);

        if (!sensorFind.getNombre().equals(sensor.getNombre())) {
            sensorFind.setNombre(sensor.getNombre());
        }
        if (!sensorFind.getTipoSensor().getNombre().equals(sensor.getTipoSensorId())) {
            sensorFind.setTipoSensor(tipoSensorDao.findByNombre(sensor.getTipoSensorId()));
        }

        sensorDao.save(sensorFind);
        return sensorMapper.entityToDto(sensorFind);
    }
    public SensorDTO buscarSensor(String sensorId) {
        Optional<Sensor> sensor = sensorDao.findById(Long.parseLong(sensorId));
        return sensorMapper.entityToDto(sensor.get());
    }

    public List<SensorDTO> listarSensoresCliente(String cliente) {
        Cliente client =  clienteDao.findByThingsBoard(cliente);
        List<SensorDTO> sensorDTOS = new ArrayList<>();
        List<Sensor_Cliente> sensorCliente = sensorClienteDao.findByCliente(client.getId());
        for(Sensor_Cliente sensor_cliente: sensorCliente){
            sensorDTOS.add(sensorMapper.entityToDto(sensor_cliente.getSensores()));
        }
        return sensorDTOS;
    }

    public void borrarSensor( String identificador){
        Sensor sensorFind = sensorDao.findByName(identificador);
        sensorDao.deleteById(sensorFind.getId());
    }
}