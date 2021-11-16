package com.dbc.pessoaapi.dto;

import lombok.Data;

import java.util.Set;
@Data
public class PessoaComEnderecoContato extends PessoaDto{

    private Set<EnderecoDTO> enderecoDTOS;
    private Set<ContatoDTO> contatoDTOS;

}
