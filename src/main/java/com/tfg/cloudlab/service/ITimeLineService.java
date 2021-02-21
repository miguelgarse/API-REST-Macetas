package com.tfg.cloudlab.service;

import org.springframework.stereotype.Service;

import com.tfg.cloudlab.dto.TimeLineDTO;
import com.tfg.cloudlab.dto.ValoresangularDTO;

import java.util.List;
@Service
public interface ITimeLineService {
    List<TimeLineDTO> valoresSensor(String sensor_id);
    List<ValoresangularDTO> valoresCliente();
}
