package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.Exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.dto.*;
import com.dbc.pessoaapi.entity.Pessoaentity;
import com.dbc.pessoaapi.kafka.Producer;
import com.dbc.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor /* Metodo Service Adicionar As Regras DE Negocio da Aplicação   */
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

    public void delete(Integer id) throws RegraDeNegocioException, JsonProcessingException {
        Pessoaentity pessoa = findById(id);
        pessoaRepository.delete(pessoa);

    }

    public List<Pessoaentity> findByNome(String nome) {
        return  pessoaRepository.findByNomeContainingIgnoreCase(nome);
    }

    public List<Pessoaentity> findBydataNascimentoBetween(LocalDate dataInicial,LocalDate dataFinal) {
        return pessoaRepository.findBydataNascimentoBetween(dataInicial, dataFinal);
    }

    public List<Pessoaentity> findByCpf(String cpf) {
        return pessoaRepository.findBycpf(cpf);
    }

    public List<PessoaComEnderecoDTO> findWithenderecos(Integer id) {
        List<Pessoaentity> pessoaentities = new ArrayList<>() ;
        if (id == null) {
            pessoaentities = pessoaRepository.findAll();
        }else {
           List<Integer> ids= new ArrayList<>();
            ids.add(id);
            pessoaentities =  pessoaRepository.findAllById(ids);

        }

        return pessoaentities.stream().map(
                        pessoaentity -> {
                            PessoaComEnderecoDTO pessoaComEnderecoDTO = objectMapper.convertValue(pessoaentity, PessoaComEnderecoDTO.class);
                            Set<EnderecoDTO> enderecoDTOS = pessoaentity.getEnderecos().stream()
                                     .map(enderecoentity ->  objectMapper.convertValue(enderecoentity, EnderecoDTO.class)).collect(Collectors.toSet());
                            pessoaComEnderecoDTO.setEnderecoDTOS(enderecoDTOS);
                            return  pessoaComEnderecoDTO;
                        }
                ).toList();


    }

    public List<PessoaComContatoDTO> findWithcontato(Integer id) {

        List<Pessoaentity> pessoaentities = new ArrayList<>() ;
        if (id == null) {
            pessoaentities = pessoaRepository.findAll();
        }else {
            List<Integer> ids= new ArrayList<>();
            ids.add(id);
            pessoaentities =  pessoaRepository.findAllById(ids);

        }

        return pessoaentities.stream().map(
                pessoaentity -> {
                    PessoaComContatoDTO pessoaComContatoDTO = objectMapper.convertValue(pessoaentity, PessoaComContatoDTO.class);
                    Set<ContatoDTO> contatoDTO = pessoaentity.getContatos().stream()
                            .map(contatoentity ->  objectMapper.convertValue(contatoentity, ContatoDTO.class)).collect(Collectors.toSet());
                    pessoaComContatoDTO.setContatoDTOS(contatoDTO);
                    return  pessoaComContatoDTO;
                }
        ).toList();

    }

    public List<PessoaComEnderecoContato> findWithEndecoContato(Integer id) {
        List<Pessoaentity> pessoaentities = new ArrayList<>() ;
        if (id == null) {
            pessoaentities = pessoaRepository.findAll();
        }else {
            List<Integer> ids= new ArrayList<>();
            ids.add(id);
            pessoaentities =  pessoaRepository.findAllById(ids);

        }

        return pessoaentities.stream().map(
                pessoaentity -> {
                    PessoaComEnderecoContato pessoaComEnderecoContato = objectMapper.convertValue(pessoaentity, PessoaComEnderecoContato.class);
                    Set<ContatoDTO> contatoDTO = pessoaentity.getContatos().stream()
                            .map(contatoentity ->  objectMapper.convertValue(contatoentity, ContatoDTO.class)).collect(Collectors.toSet());
                    pessoaComEnderecoContato.setContatoDTOS(contatoDTO);
                    Set<EnderecoDTO> enderecoDTOS = pessoaentity.getEnderecos().stream()
                            .map(enderecoentity ->  objectMapper.convertValue(enderecoentity, EnderecoDTO.class)).collect(Collectors.toSet());
                    pessoaComEnderecoContato.setEnderecoDTOS(enderecoDTOS);
                    return  pessoaComEnderecoContato;
                }
        ).toList();


    }

    public List<Pessoaentity> porDataDeNascimentoEntreDuasDatas(LocalDate dataInicial,LocalDate dataFinal) {
        return pessoaRepository.porDataDeNascimentoEntreDuasDatas(dataInicial, dataFinal);
    }


    public List<Pessoaentity> quePossuemEndereco() {
        return pessoaRepository.procuraPossuemEndereco();
    }

    public List<Pessoaentity> procuraSemEndereco() {
        return pessoaRepository.procuraSemEndereco();
    }
}

