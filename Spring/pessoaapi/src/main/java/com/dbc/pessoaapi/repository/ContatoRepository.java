package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.entity.Contatoentity;
import com.dbc.pessoaapi.entity.TipoContato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContatoRepository extends JpaRepository<Contatoentity,Integer> {

    @Query("SELECT c FROM Contato c WHERE c.tipoContato = :tipoContato")
    List<Contatoentity> porTipodeContato(TipoContato tipoContato);

    @Query(value = "SELECT * FROM VEM_SER.Contato c WHERE c.id_pessoa = ?1 ", nativeQuery = true)
    List<Contatoentity> procurarPoridPessoa(Integer idPessoa);


}
