package com.dbc.pessoaapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Set;
@Data
public class PessoaComContatoDTO extends PessoaDto {

    private Set<ContatoDTO> contatoDTOS;
}
