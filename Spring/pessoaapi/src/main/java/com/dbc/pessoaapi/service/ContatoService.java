package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.entity.Contato;
import com.dbc.pessoaapi.entity.Pessoa;
import com.dbc.pessoaapi.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContatoService {
    @Autowired
    private ContatoRepository contatoRepository;

    public ContatoService(){

    }

    public Contato create(Integer id, Contato contato) {
        return contatoRepository.create(id, contato);
    }

    public List<Contato> list(){
        return contatoRepository.list();
    }

    public Contato update(Integer id,Contato contatoAtualizado) throws Exception {
        return contatoRepository.update(id, contatoAtualizado);
    }

    public void delete(Integer id) throws Exception {
        contatoRepository.delete(id);
    }

    public List<Contato> listByNumero(String numero) {
        return contatoRepository.listByNumero(numero);
    }

}
