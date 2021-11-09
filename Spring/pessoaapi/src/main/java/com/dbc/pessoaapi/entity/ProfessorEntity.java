package com.dbc.pessoaapi.entity;

import com.dbc.pessoaapi.entity.pk.ProfessorPk;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "professor")
public class ProfessorEntity {

    @EmbeddedId
    private ProfessorPk professorPk;


   @Column(name = "nome")
    private String nome;

   @Column(name = "salario")
    private Double salario;
}
