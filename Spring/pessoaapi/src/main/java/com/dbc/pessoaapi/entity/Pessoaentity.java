package com.dbc.pessoaapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name="pessoa") /* Metodo Entity Mapeamento do Banco de Dados   */
public class Pessoaentity implements Serializable {

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

    @JsonIgnore
    @OneToMany(mappedBy = "pessoaentity",fetch = FetchType.LAZY)
    private Set<Contatoentity> contatos;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Pessoa_x_Pessoa_Endereco",joinColumns = @JoinColumn(name = "id_pessoa"),
    inverseJoinColumns = @JoinColumn(name = "id_endereco")
    )
    private Set<Enderecoentity> enderecos;

    }
