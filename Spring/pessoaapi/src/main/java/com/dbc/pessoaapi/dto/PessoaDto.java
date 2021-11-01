package com.dbc.pessoaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDto {
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
