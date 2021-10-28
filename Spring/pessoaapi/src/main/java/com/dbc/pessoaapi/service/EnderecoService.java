package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.entity.Endereco;
import com.dbc.pessoaapi.entity.Pessoa;
import com.dbc.pessoaapi.repository.ContatoRepository;
import com.dbc.pessoaapi.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco create(Integer idPessoa, Endereco endereco) throws Exception {
        return enderecoRepository.create(idPessoa, endereco);

    }
    public List<Endereco> list() {
        return enderecoRepository.list();
    }
    public Endereco update(Integer id,
                         Endereco enderecoAtualizar) throws Exception {
        return enderecoRepository.update(id, enderecoAtualizar);
    }
    public void delete(Integer id) throws Exception {
        enderecoRepository.delete(id);
    }
    public List<Endereco> listByIdPessoa(Integer id) {
        return enderecoRepository.listByIdPessoa(id);
    }
    public List<Endereco> listById(Integer id) {
        return enderecoRepository.listById(id);
    }

}



