package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.entity.Pessoaentity;
import com.dbc.pessoaapi.service.PessoaService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository /*Metodo Repository metodo quefas Aligação com o Banco de Dados  */
public interface PessoaRepository extends JpaRepository<Pessoaentity,Integer> {
    List<Pessoaentity> findByNomeContainingIgnoreCase(String nome);
     List<Pessoaentity> findBycpf(String cpf);
    List<Pessoaentity> findBydataNascimentoBetween(LocalDate dataInicial,LocalDate dataFinal);

    @Query("SELECT p FROM pessoa p WHERE p.dataNascimento >=  :dataInicial AND p.dataNascimento  <= :dataFinal")
    List<Pessoaentity> porDataDeNascimentoEntreDuasDatas(LocalDate dataInicial,LocalDate dataFinal);

    @Query("SELECT p FROM pessoa p WHERE p.enderecos = Empty")
    List<Pessoaentity> procuraPossuemEndereco();


    @Query(value = "SELECT p.* FROM VEM_SER.pessoa p left JOIN VEM_SER.PESSOA_X_PESSOA_ENDERECO pxpe ON (p.ID_PESSOA = pxpe.ID_PESSOA) \n" +
            "WHERE pxpe.id_endereco IS null", nativeQuery = true)
    List<Pessoaentity> procuraSemEndereco();



}
