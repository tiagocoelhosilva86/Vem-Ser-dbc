package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.Exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.dto.EnderecoCreateDto;
import com.dbc.pessoaapi.dto.EnderecoDTO;
import com.dbc.pessoaapi.dto.PessoaCreateDTO;
import com.dbc.pessoaapi.dto.PessoaDto;
import com.dbc.pessoaapi.entity.Enderecoentity;
import com.dbc.pessoaapi.entity.Pessoaentity;
import com.dbc.pessoaapi.repository.EnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;
    private final ObjectMapper objectMapper;


    public EnderecoDTO create(Integer idPessoa, EnderecoCreateDto enderecoDTO) throws Exception {

        Enderecoentity enderecoentity =  objectMapper.convertValue(enderecoDTO,Enderecoentity.class);
        Enderecoentity enderecoentity1  = enderecoRepository.save(enderecoentity);

        EnderecoDTO enderecoDTO1 = objectMapper.convertValue(enderecoentity1, EnderecoDTO.class);

        return enderecoDTO1;


   // public Enderecoentity create(Integer idPessoa, Enderecoentity enderecoentity) throws Exception {
     //   return enderecoRepository.create(idPessoa, enderecoentity);

    }
    public List<EnderecoDTO> list() {
        return enderecoRepository.findAll().stream()
                .map(endereco -> objectMapper.convertValue(endereco,EnderecoDTO.class))
                .collect(Collectors.toList());
    }
    public EnderecoDTO update(Integer id,
                                 EnderecoCreateDto enderecoCreateDto) throws Exception {
        Enderecoentity enderecoentity =  objectMapper.convertValue(enderecoCreateDto,Enderecoentity.class);
        enderecoRepository.findById(id).orElseThrow(() -> new Exception("endereço não encontrada"));
        enderecoentity.setIdEndereco(id);
        Enderecoentity enderecoentity1 = enderecoRepository.save(enderecoentity);

        EnderecoDTO enderecoDTO1 = objectMapper.convertValue(enderecoentity1, EnderecoDTO.class);
        return enderecoDTO1;
    }
    public void delete(Integer id) throws Exception {
        Enderecoentity enderecoDeletar = enderecoRepository.findById(id)
        .orElseThrow(() -> new RegraDeNegocioException("endereco não encontrada"));
        enderecoRepository.delete(enderecoDeletar);
    }
/*
    public List<EnderecoDTO> listByIdPessoa(Integer id) {
        return enderecoRepository.listByIdPessoa(id).stream()
                .map(endereco -> objectMapper.convertValue(endereco,EnderecoDTO.class))
                .collect(Collectors.toList());
    }*/

    public EnderecoDTO listById(Integer id) throws RegraDeNegocioException {
         Enderecoentity enderecoentity = enderecoRepository.findById(id)
                 .orElseThrow(() -> new RegraDeNegocioException("endereco não encontrada"));;
         EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoentity,EnderecoDTO.class);
         return enderecoDTO;
    }

}



