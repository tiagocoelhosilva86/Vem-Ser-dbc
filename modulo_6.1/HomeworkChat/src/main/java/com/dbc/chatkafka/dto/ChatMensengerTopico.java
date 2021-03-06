package com.dbc.chatkafka.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAccessor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChatMensengerTopico extends ChatMensenger {

    private String topico;



}
