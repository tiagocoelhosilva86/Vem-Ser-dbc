package com.dbc.chatkafka.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChatMensenger {


    @ApiModelProperty(value = "Data atual")
    private LocalDateTime data;

    @ApiModelProperty(value = "Tiago")
    private String usuario;

    @ApiModelProperty(value = "mensagem enviada ão usuario ")
    private  String mensagen;
}
