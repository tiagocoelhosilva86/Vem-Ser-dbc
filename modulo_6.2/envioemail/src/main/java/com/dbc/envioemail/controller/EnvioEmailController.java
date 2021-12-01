package com.dbc.envioemail.controller;

import com.dbc.envioemail.dto.EmailDTO;
import com.dbc.envioemail.kafka.Producer;
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
