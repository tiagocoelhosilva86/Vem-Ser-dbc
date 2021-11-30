package com.dbc.chatkafka.controller;

import com.dbc.chatkafka.dto.ChatMensenger;
import com.dbc.chatkafka.dto.ChatMensengerTopico;
import com.dbc.chatkafka.kafka.Producer;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class ChatController {
    private final Producer producer;

    @PostMapping("/chat-geral")
    private void enviar(@RequestBody ChatMensenger chatMensenger) throws JsonProcessingException {
        producer.send(chatMensenger, "chat-geral");
    }

    @PostMapping("/chat-privado")
    private void enviarPrivado(@RequestBody ChatMensengerTopico chatMensenger) throws JsonProcessingException {
        producer.send(chatMensenger, "chat-"+chatMensenger.getTopico());
    }
}
