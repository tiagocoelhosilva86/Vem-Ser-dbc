package com.dbc.pessoaapi.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "Endereco_Pessoa")
public class Enderecoentity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Endereco_SEQUENCIA")
    @SequenceGenerator(name = "Endereco_SEQUENCIA",sequenceName = "seq_Endereco_contato",allocationSize = 1)
    @Column(name="id_Endereco")
    private Integer idEndereco;


    @Enumerated(EnumType.ORDINAL)
    @Column(name="tipo")
    private TipoEndereco tipo;

    @Column(name="logradouro")
    private String logradouro;

    @Column(name="numero")
    private Integer numero;

    @Column(name="complemento")
    private String complemento;

    @Column(name="cep")
    private String cep;

    @Column(name="cidade")
    private String cidade;

    @Column(name="estado")
    private String estado;

    @Column(name="pais")
    private String pais;


}

