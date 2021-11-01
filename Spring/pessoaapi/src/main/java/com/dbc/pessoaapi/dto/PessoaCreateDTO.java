package com.dbc.pessoaapi.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
public class PessoaCreateDTO {
        private Integer idPessoa;

        @NotEmpty
        @NotBlank
        private String nome;


        @NotNull
        @Past
        private LocalDate dataNascimento;
        @NotBlank
        @NotEmpty
        @Size(max = 11, min = 11, message = "cpf deve conter 11 caracteres")
        private String cpf;
    }


