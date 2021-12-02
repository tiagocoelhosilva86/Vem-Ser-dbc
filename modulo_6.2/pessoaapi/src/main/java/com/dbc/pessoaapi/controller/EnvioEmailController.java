package com.dbc.pessoaapi.controller;


import com.dbc.pessoaapi.dto.EmailDTO;
import com.dbc.pessoaapi.kafka.Producer;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class EnvioEmailController {
    private final Producer producer;

    @PostMapping("/enviar")
    private void enviar(EmailDTO mensagem) throws JsonProcessingException {
        producer.sendMessage(mensagem);
    }
}
