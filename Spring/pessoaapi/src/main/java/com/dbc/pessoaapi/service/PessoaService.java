package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.Exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.dto.PessoaCreateDTO;
import com.dbc.pessoaapi.dto.PessoaDto;
import com.dbc.pessoaapi.entity.Pessoaentity;
import com.dbc.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private  final PessoaRepository pessoaRepository;
    private final ObjectMapper objectMapper;



    public PessoaDto create(PessoaCreateDTO pessoaCreateDTO) throws Exception {

        Pessoaentity pessoaentity = objectMapper.convertValue(pessoaCreateDTO, Pessoaentity.class);
        Pessoaentity pessoaCriada = pessoaRepository.save(pessoaentity);
        PessoaDto pessoaDTO = objectMapper.convertValue(pessoaCriada, PessoaDto.class);
        return pessoaDTO;


    }
    public List<PessoaDto> list() {
        return pessoaRepository.findAll()
                .stream()
                .map(pessoa -> objectMapper.convertValue(pessoa,PessoaDto.class))
                .collect(Collectors.toList());
    }

    public PessoaDto getById(Integer id) throws RegraDeNegocioException {
        Pessoaentity entity = findById(id);
        PessoaDto dto = objectMapper.convertValue(entity, PessoaDto.class);
        return dto;
    }
    private Pessoaentity findById(Integer id) throws RegraDeNegocioException {
        Pessoaentity entity = pessoaRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("pessoa não encontrada"));
        return entity;
    }

    public Pessoaentity update(Integer id, PessoaCreateDTO pessoaCreateDTO) throws RegraDeNegocioException {
        findById(id);
        Pessoaentity entity = objectMapper.convertValue(pessoaCreateDTO, Pessoaentity.class);
        entity.setIdPessoa(id);
        Pessoaentity update = pessoaRepository.save(entity);
        Pessoaentity dto = objectMapper.convertValue(update, Pessoaentity.class);
        return dto;
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        Pessoaentity pessoa = findById(id);
        pessoaRepository.delete(pessoa);
    }

    public List<Pessoaentity> findByNome(String nome) {
        return  pessoaRepository.findByNomeContainingIgnoreCase(nome);
    }

    public List<Pessoaentity> findBydataNascimentoBetween(LocalDate dataInicial,LocalDate dataFinal) {
        return pessoaRepository.findBydataNascimentoBetween(dataInicial, dataFinal);
    }

    public List<Pessoaentity> findBycpf(String cpf) {
        return pessoaRepository.findBycpf(cpf);
    }
}

