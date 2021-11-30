package com.dbc.veiculoprodutorconsumidor.service;

import com.dbc.veiculoprodutorconsumidor.dto.SensorVeiculo;
import com.dbc.veiculoprodutorconsumidor.repository.SensorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class SensorVeiculoService {
private final SensorRepository sensorRepository;

    public List<SensorVeiculo> findAll(){
        return sensorRepository.findAll();
    }
}
