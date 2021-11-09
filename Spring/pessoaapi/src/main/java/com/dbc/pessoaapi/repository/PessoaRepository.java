package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.entity.Pessoaentity;
import com.dbc.pessoaapi.service.PessoaService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoaentity,Integer> {
    List<Pessoaentity> findByNomeContainingIgnoreCase(String nome);
     List<Pessoaentity> findBycpf(String cpf);
    List<Pessoaentity> findBydataNascimentoBetween(LocalDate dataInicial,LocalDate dataFinal);



}
