package com.tfg.cloudlab.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tfg.cloudlab.dto.EventsDTO;
import com.tfg.cloudlab.dto.SensorValueDto;
import com.tfg.cloudlab.mappers.EventsMapper;
import com.tfg.cloudlab.mappers.TimelineMapper;
import com.tfg.cloudlab.modelo.Cliente;
import com.tfg.cloudlab.modelo.SensorValueEntity;
import com.tfg.cloudlab.modelo.Sensor_Cliente;
import com.tfg.cloudlab.modelo.dao.ClienteDao;
import com.tfg.cloudlab.modelo.dao.EventsDao;
import com.tfg.cloudlab.modelo.dao.SensorClienteDao;
import com.tfg.cloudlab.modelo.dao.SensorValueRepository;
import com.tfg.cloudlab.service.IServicio;
import com.tfg.cloudlab.service.config.Constantes;

@Service
public class Servicio implements IServicio {

    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private ClienteDao clienteDao;
    
    @Autowired
    private SensorValueRepository sensorValueRepository;
    
    @Autowired
    private TimelineMapper timelineMapper;
    
    @Autowired
    private SensorClienteDao sensorClienteDao;
    
    @Autowired
    private EventsDao eventsDao;
    
    @Autowired
    private EventsMapper eventsMapper;

    @Bean
    private RestTemplate restTemplate(RestTemplateBuilder builder) {
        // Do any additional configuration here
        return builder.build();
    }

    private HttpHeaders cabeceras() {
        HttpHeaders headers = new HttpHeaders();
        // headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("X-Authorization", "Bearer ".concat(Constantes.TOKEN));
        headers.add("Accept", "*/*");
        headers.add("Cache-Control", "no-cache");
        headers.add("Accept-Encoding", "gzip, deflate");
        headers.add("Connection", "keep-alive");
        headers.add("cache-control", "no-cache");
        headers.add("user-agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        return headers;
    }

    public List<SensorValueDto> persisitirDatos(String device, String idThingsboard) {
        Logger logger = LoggerFactory.getLogger(Servicio.class);
        Cliente cliente = clienteDao.findByThingsBoard(idThingsboard);
        List<SensorValueDto> listaResultado = new ArrayList<SensorValueDto>();
        if (device != null) {
            String url = Constantes.ENDPOINT.concat(device).concat("/values/timeseries");
            ObjectMapper objectMapper = new ObjectMapper();
            HttpEntity<String> entity = new HttpEntity<String>(null, this.cabeceras());
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

            try {
                Map valores = objectMapper.readValue(response.getBody(), Map.class);
                logger.info("VALORES OBTENIDOS: ", valores);
                Object[] arrayKeys = valores.keySet().toArray();
                for (Object object : arrayKeys) {
                    SensorValueEntity timeline = new SensorValueEntity();
                    Object lectura = valores.get(object);
                    try {
                        Sensor_Cliente sensor_cliente = sensorClienteDao.findByClienteSensor(idThingsboard, object.toString());
                        String valor = ((LinkedHashMap) ((ArrayList) lectura).get(0)).get("value").toString();
                        BigDecimal valorDecimal = new BigDecimal(valor);
                        timeline.setDateCreated(new Date());
                        timeline.setSensor(sensor_cliente.getSensores());
                        timeline.setValor(valorDecimal);
                        sensorValueRepository.save(timeline);
                        listaResultado.add(timelineMapper.entityToDto(timeline));
                    } catch (EmptyResultDataAccessException e) {

                    }
                }
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

        }
        return listaResultado;
    }

    public String recogerConfiguracion(String device) {
        String url = Constantes.ENDPOINT_ATTRIBUTES.concat(device).concat("/attributes");
        ObjectMapper objectMapper = new ObjectMapper();
        HttpEntity<String> entity = new HttpEntity<String>(null, this.cabeceras());
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        return response.getBody();
    }

    public List<EventsDTO> riego(String cliente) {
        Cliente client = clienteDao.findByThingsBoard(cliente);
        return eventsMapper.entitiesToDto(eventsDao.findByActionDesc("abrir el riego", client.getId()));
    }
}
