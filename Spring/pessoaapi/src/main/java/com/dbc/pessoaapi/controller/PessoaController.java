package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.dto.PessoaCreateDTO;
import com.dbc.pessoaapi.dto.PessoaDto;
import com.dbc.pessoaapi.entity.Pessoaentity;
import com.dbc.pessoaapi.service.PessoaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated


@RequestMapping("/pessoa")
@Slf4j

public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    public PessoaController() {

    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello world!";
    }

    @PostMapping
    public PessoaDto create(@RequestBody@Valid PessoaCreateDTO pessoaCreateDTO) throws Exception {
        log.info("iniciando criação da pessoa");
        PessoaDto pessoaDto = pessoaService.create(pessoaCreateDTO);
        log.info("pessoa criada com sucesso");
        return pessoaDto;
    }

    @GetMapping
    public List<PessoaDto> list() {
        return pessoaService.list();
    }

    @GetMapping("/byname")
    public List<PessoaDto> listByName(@RequestParam("nome") String nome) {
        return pessoaService.listByName(nome);
    }


    @PutMapping("/{idPessoa}")
    public PessoaDto update(@PathVariable("idPessoa") Integer id,
                               @RequestBody @Valid PessoaCreateDTO PessoaDtoAtualizar) throws Exception {
        log.info("iniciando atualização da pessoa");
        PessoaDto pessoaDto =  pessoaService.update(id, PessoaDtoAtualizar);
        log.info(" pessoa atualizada");
        return pessoaDto;
    }

    @DeleteMapping("/{idPessoa}")
    public void delete(@PathVariable("idPessoa") Integer id) throws Exception {
        log.info(" pessoa deletada com suçesso");
        pessoaService.delete(id);
    }
}
