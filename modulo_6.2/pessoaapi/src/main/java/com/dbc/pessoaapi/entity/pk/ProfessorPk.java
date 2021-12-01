package com.dbc.pessoaapi.entity.pk;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorPk implements Serializable {
    @Column(name = "id_professor")
    private Integer idprofessor;

    @Column(name = "id_universidade" )
    private Integer idUniversidade;
}
