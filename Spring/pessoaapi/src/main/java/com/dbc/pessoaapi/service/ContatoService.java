package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.Exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.dto.ContatoDTO;
import com.dbc.pessoaapi.dto.PessoaDto;
import com.dbc.pessoaapi.entity.Contatoentity;
import com.dbc.pessoaapi.repository.ContatoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContatoService {
    @Autowired
    private ContatoRepository contatoRepository;
    private final ObjectMapper objectMapper;


    public ContatoDTO create(Integer id,ContatoDTO contatoDTO) throws Exception {

        Contatoentity contatoentity = objectMapper.convertValue(contatoDTO, Contatoentity.class);
        if (contatoentity.getIdPessoa() == 0 || contatoentity.getIdPessoa() ==  null){
            throw new  RegraDeNegocioException("campo não pode ser 0 ou null");
        }
        Contatoentity contatoCriada = contatoRepository.save(contatoentity);

        ContatoDTO contatoDTO1 = objectMapper.convertValue(contatoCriada, ContatoDTO.class);
        return contatoDTO1;


    }


    public List<Contatoentity> list(){
        return contatoRepository.findAll();
    }

    public ContatoDTO update(Integer id, ContatoDTO contatoDTO) throws Exception {
        Contatoentity contatoentity = objectMapper.convertValue(contatoDTO, Contatoentity.class);
        if (contatoentity.getIdPessoa() == 0 || contatoentity.getIdPessoa() ==  null){
            throw new  RegraDeNegocioException("campo não pode ser 0 ou null");
        }
        contatoentity.setIdContato(id);
        Contatoentity contatoentity1= contatoRepository.save( contatoentity);

        ContatoDTO contatoDTO1 = objectMapper.convertValue(contatoentity1, ContatoDTO.class);
        return contatoDTO1;

    }

    public void delete(Integer id) throws Exception {
        Contatoentity contatoentity = contatoRepository.getById(id);
        contatoRepository.delete(contatoentity);
    }
/*
    public List<ContatoDTO> listByNumero(String numero) {
        return contatoRepository.listByNumero(numero).stream()
                .map(contato -> objectMapper.convertValue(contato,ContatoDTO.class))
                .collect(Collectors.toList());
    }*/

}
