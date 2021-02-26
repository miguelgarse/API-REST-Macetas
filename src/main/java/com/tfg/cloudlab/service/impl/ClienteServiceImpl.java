package com.tfg.cloudlab.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfg.cloudlab.dto.ClienteDTO;
import com.tfg.cloudlab.mappers.ClienteMapper;
import com.tfg.cloudlab.modelo.Cliente;
import com.tfg.cloudlab.modelo.Sensor_Cliente;
import com.tfg.cloudlab.modelo.dao.ClienteDao;
import com.tfg.cloudlab.modelo.dao.SensorClienteDao;
import com.tfg.cloudlab.service.IClienteService;
@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private ClienteDao clienteDao;
    @Autowired
    private ClienteMapper clienteMapper;
    @Autowired
    private SensorClienteDao sensorClienteDao;

    public ClienteDTO añadirCliente(ClienteDTO clienteDto) {
        clienteDao.save(clienteMapper.dtoToEntity(clienteDto));
        return clienteMapper.entityToDto(clienteDao.findByThingsBoard(clienteDto.getThingsboardId()));
    }

    public ClienteDTO modificarCliente(ClienteDTO clienteDto ,String identificador) {
        Cliente cliente = clienteDao.findByThingsBoard(identificador);

            if (!cliente.getDescripcion().equals(clienteDto.getDescripcion())) {
                cliente.setDescripcion(clienteDto.getDescripcion());
            }
            if (!cliente.getThingsboardId().equals(clienteDto.getThingsboardId())) {
                cliente.setThingsboardId(clienteDto.getThingsboardId());
            }
            clienteDao.save(cliente);
            return clienteMapper.entityToDto(cliente);

    }

    public ClienteDTO borrarCliente(String clienteId) {
        Cliente cliente = clienteDao.findByThingsBoard(clienteId);
        clienteDao.deleteById(cliente.getId());
        return clienteMapper.entityToDto(cliente);
    }

    public ClienteDTO buscarCliente(String identificador){
        return clienteMapper.entityToDto(clienteDao.findByThingsBoard(identificador));
    }

    public List<ClienteDTO> listarClientes() {
        List<Cliente> clientes = (List<Cliente>) clienteDao.findAll();
        return clienteMapper.entitiesToDto(clientes);
    }

    public ClienteDTO buscarPorSensor(String sensorId) {
        Sensor_Cliente sensorCliente = sensorClienteDao.findBySensor(sensorId);

        return clienteMapper.entityToDto(sensorCliente.getCliente());
    }

}
