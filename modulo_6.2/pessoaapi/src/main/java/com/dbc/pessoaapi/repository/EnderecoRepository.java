package com.dbc.pessoaapi.repository;
import com.dbc.pessoaapi.entity.Contatoentity;
import com.dbc.pessoaapi.entity.Enderecoentity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EnderecoRepository extends JpaRepository<Enderecoentity,Integer> {

    @Query("SELECT ep FROM Endereco_Pessoa ep WHERE ep.pais = :pais")
    List<Enderecoentity> procurarPorPais(String pais);

    @Query("SELECT ep FROM Endereco_Pessoa ep JOIN ep.pessoas p WHERE p.idPessoa = :idPessoa")
    List<Enderecoentity> procurarPoridpessoa(Integer idPessoa);


    @Query(value = "SELECT * FROM VEM_SER.ENDERECO_PESSOA ep WHERE ep.pais = ?1 or ep.cidade = ?1 ", nativeQuery = true)
    List<Enderecoentity> procurarPorCidadeOuPais(String cidadePais);


    @Query(value = "SELECT * FROM VEM_SER.ENDERECO_PESSOA ep WHERE ep.complemento is null ", nativeQuery = true)
    List<Enderecoentity> procurarSemComplemento();


    @Query("SELECT ep FROM Endereco_Pessoa ep WHERE ep.pais = :pais")
    Page<Contatoentity> findByPais(String pais, Pageable pageable);
}
