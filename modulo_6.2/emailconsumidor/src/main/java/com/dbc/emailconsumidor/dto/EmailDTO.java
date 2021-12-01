package com.dbc.emailconsumidor.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EmailDTO {

    private String destinatario;

    private   String assunto;

    private   String texto;
}
