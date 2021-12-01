package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.Exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.dto.*;
import com.dbc.pessoaapi.entity.Enderecoentity;
import com.dbc.pessoaapi.entity.Pessoaentity;
import com.dbc.pessoaapi.service.PessoaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.ManyToOne;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@Validated


@RequestMapping("/pessoa") /*Metodo Controller Controla o Fluxo Da Aplicação  */
@Slf4j

public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    public PessoaController() {

    }

    @ApiOperation(value = "Criando Pessoa")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "pessoa Criada com sucesso!"),
            @ApiResponse(code = 400, message = "pessoa com id não encontrado"),
            @ApiResponse(code = 500, message = "Exceção no sistema!")
    })
    @PostMapping
    public PessoaDto create(@RequestBody@Valid PessoaCreateDTO pessoaCreateDTO) throws Exception {
        log.info("iniciando criação da pessoa");
        PessoaDto pessoaDto = pessoaService.create(pessoaCreateDTO);
        log.info("pessoa criada com sucesso");
        return pessoaDto;
    }

    @GetMapping
    @ApiOperation(value = "lista  Pessoas")
    public List<PessoaDto> list() {
        log.info("iniciando busca da pessoa");
        return pessoaService.list();
    }

    @ApiOperation(value = "Atualizar uma Nova Pessoa Pelo ID Informado")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "pessoa atualizada com sucesso!"),
            @ApiResponse(code = 400, message = "pessoa com id não encontrado"),
            @ApiResponse(code = 500, message = "Exceção no sistema!")
    })
    @PutMapping("/{idPessoa}")
    public Pessoaentity update(@PathVariable("idPessoa") Integer id,
                               @RequestBody @Valid PessoaCreateDTO PessoaDtoAtualizar) throws RegraDeNegocioException {
        log.info("iniciando atualização da pessoa");
        Pessoaentity pessoaDto =  pessoaService.update(id, PessoaDtoAtualizar);
        log.info(" pessoa atualizada");
        return pessoaDto;
    }
    @ApiOperation(value = "Deletar Pessoa")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "pessoa Deletada com sucesso!"),
            @ApiResponse(code = 400, message = "pessoa com id não encontrado"),
            @ApiResponse(code = 500, message = "Exceção no sistema!")
    })
    @DeleteMapping("/{idPessoa}")
    public void delete(@PathVariable("idPessoa") Integer id) throws Exception {
        log.info(" pessoa deletada com suçesso");
        pessoaService.delete(id);
    }

    @GetMapping("/find-by-nome")
    public List<Pessoaentity>findByNome(@RequestParam String nome){
        return pessoaService.findByNome(nome);
    }

    @GetMapping("/find-by-Cpf")
    public List<Pessoaentity> findByCpf(@RequestParam String cpf) {
        log.info("iniciando busca por cpf");
        return pessoaService.findByCpf(cpf);
    }

    @GetMapping("/find-by-dataNascimento")
    public List<Pessoaentity> findByidade(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal) {
        return pessoaService.findBydataNascimentoBetween(dataInicial, dataFinal);

    }
    @GetMapping("/listar-com-enderecos/{idPessoa}")
    public List<PessoaComEnderecoDTO> findWithenderecos(@PathVariable(value = "idPessoa", required = false) Integer id){
        return pessoaService.findWithenderecos(id);
    }
    @GetMapping("/listar-com-contato/{idPessoa}")
    public List<PessoaComContatoDTO> findWithcontato(@PathVariable(value = "idPessoa", required = false) Integer id){
        return pessoaService.findWithcontato(id);
    }
    @GetMapping("/Pessoa-completo/{idPessoa}")
    public List<PessoaComEnderecoContato> findWithEnderecoContato(@PathVariable(value = "idPessoa", required = false) Integer id){
        return pessoaService.findWithEndecoContato(id);
    }

    @GetMapping("/procura-por-dataNascimento")
    public List<Pessoaentity> procuraPorDataNascimento(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
                                                       @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal) {
        return pessoaService.porDataDeNascimentoEntreDuasDatas(dataInicial, dataFinal);

    }

    @GetMapping("/pessoas-possuem-endereco")
    public List<Pessoaentity> procuraPorDataNascimento() {
        return pessoaService.quePossuemEndereco();

    }


    @GetMapping("/pessoas-sem-endereco")
    public List<Pessoaentity> procuraSemEndereco() {
        return pessoaService.procuraSemEndereco();

    }
}
