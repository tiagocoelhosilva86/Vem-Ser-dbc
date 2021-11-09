package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.entity.Contatoentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends JpaRepository<Contatoentity,Integer> {

}
