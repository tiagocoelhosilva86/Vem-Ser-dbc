package com.dbc.pessoaapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DadosPessoaisDTO {
    private String nome;
    private String cpf;
    private String rg;
    private String cnh;
    private String nomeMae;
    private String nomePai;
    private String tituloEleitor;
    private Sexo sexo;


}
