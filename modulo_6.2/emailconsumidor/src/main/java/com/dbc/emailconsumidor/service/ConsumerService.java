package com.dbc.emailconsumidor.service;

import com.dbc.emailconsumidor.dto.EmailDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ConsumerService {
    private static final Logger log = LoggerFactory.getLogger(ConsumerService.class);
    private final KafkaTemplate<String, String> stringKafkaTemplate;
    private final EmailService emailService;
    private final ObjectMapper objectMapper;

    @KafkaListener(
            topics = {"${kafka.topic.string}"},
            groupId = "${kafka.group-id}",
            containerFactory = "listenerContainerFactory"
    )
    public void consume(@Payload String mensagem, @Header("kafka_receivedMessageKey") String key, @Header("kafka_offset") Long offset) throws JsonProcessingException {
        log.info("MENSAGEM LIDA: '{}', CHAVE: '{}', OFFSET: '{}'", new Object[]{mensagem, key, offset});
        this.emailService.enviarEmailSimples((EmailDTO) this.objectMapper.readValue(mensagem, EmailDTO.class));
    }

    public ConsumerService(final KafkaTemplate<String, String> stringKafkaTemplate, final EmailService emailService, final ObjectMapper objectMapper) {
        this.stringKafkaTemplate = stringKafkaTemplate;
        this.emailService = emailService;
        this.objectMapper = objectMapper;
    }
}
