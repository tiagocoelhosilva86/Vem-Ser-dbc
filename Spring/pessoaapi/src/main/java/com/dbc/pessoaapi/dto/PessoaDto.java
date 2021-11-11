package com.dbc.pessoaapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor /*Metodo Dto Atributos que Serão Mostrados ao Usuario   */
public class PessoaDto {
    private Integer idPessoa;

    @NotEmpty
    @NotBlank
    @ApiModelProperty(value = "Nome da Pessoa")
    private String nome;


    @NotNull
    @Past
    @ApiModelProperty(value = "Data de Nascimento")
    private LocalDate dataNascimento;
    @NotBlank
    @NotEmpty
    @Size(max = 11, min = 11, message = "cpf deve conter 11 caracteres")
    @ApiModelProperty(value = "CPF")
    private String cpf;

}
