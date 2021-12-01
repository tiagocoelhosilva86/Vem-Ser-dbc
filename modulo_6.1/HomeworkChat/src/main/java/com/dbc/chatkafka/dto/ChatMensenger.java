package com.dbc.chatkafka.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChatMensenger {


    @ApiModelProperty(value = "Data atual")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataCriacao;

    @ApiModelProperty(value = "Tiago")
    private String usuario;

    @ApiModelProperty(value = "mensagem enviada ão usuario ")
    private  String mensagem;
}
