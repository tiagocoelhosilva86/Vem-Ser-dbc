package com.dbc.veiculoprodutorconsumidor.controller;

import com.dbc.veiculoprodutorconsumidor.dto.SensorVeiculo;
import com.dbc.veiculoprodutorconsumidor.kafka.Producer;
import com.dbc.veiculoprodutorconsumidor.repository.SensorRepository;
import com.dbc.veiculoprodutorconsumidor.service.SensorVeiculoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class ProdutorController {
    private final Producer producer;
    private final SensorRepository sensorRepository;

    @PostMapping("/enviar")
    private void enviar(@RequestBody SensorVeiculo sensorVeiculo) throws JsonProcessingException {
        producer.send(sensorVeiculo);
    }
    @GetMapping()
    private List<SensorVeiculo> list(){return sensorRepository.findAll();}
}
