package com.dbc.pessoaapi.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name="pessoa")
public class Pessoaentity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PESSOA_SEQUENCIA")
    @SequenceGenerator(name = "PESSOA_SEQUENCIA",sequenceName = "seq_pessoa2",allocationSize = 1)
    @Column(name="id_pessoa")
    private Integer idPessoa;

    @Column(name="email")
    private String email;

    @Column(name="nome")
    private String nome;

    @Column(name="data_nascimento")
    private LocalDate dataNascimento;


    @Column(name = "cpf")
    private String cpf;

    }
