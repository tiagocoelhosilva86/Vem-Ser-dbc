package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.entity.Pessoaentity;
import com.dbc.pessoaapi.entity.ProfessorEntity;
import com.dbc.pessoaapi.entity.pk.ProfessorPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorEntity, ProfessorPk> {
}
