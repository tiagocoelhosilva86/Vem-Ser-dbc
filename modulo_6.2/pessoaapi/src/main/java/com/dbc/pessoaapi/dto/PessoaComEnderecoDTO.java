package com.dbc.pessoaapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Set;
@Data
public class PessoaComEnderecoDTO extends PessoaDto {

    private Set<EnderecoDTO> enderecoDTOS;
}
