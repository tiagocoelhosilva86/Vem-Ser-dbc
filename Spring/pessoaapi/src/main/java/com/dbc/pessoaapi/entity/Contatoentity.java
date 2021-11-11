package com.dbc.pessoaapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="Contato")
public class Contatoentity {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Contato_SEQUENCIA")
    @SequenceGenerator(name = "Contato_SEQUENCIA",sequenceName = "seq_contato",allocationSize = 1)
    @Column(name="id_contato")
    private Integer idContato;

    @Column(name = "tipo")
    @Enumerated(EnumType.ORDINAL)
    private TipoContato tipoContato;

    @Column(name="numero")
    private String numero;

    @Column(name="descricao")
    private String descricao;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pessoa",referencedColumnName = "id_pessoa")
    private Pessoaentity pessoaentity;

}
