package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.entity.Contato;
import com.dbc.pessoaapi.entity.Pessoa;
import com.dbc.pessoaapi.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/contato")
@Validated
public class ContatoController {
    @Autowired
    private ContatoService contatoService;

    public ContatoController(){
    }

    @GetMapping("/teste")
    public String teste(){
        return "teste";
    }

    @GetMapping
    public List<Contato> list() {
        return contatoService.list();
    }

    @GetMapping("/bynumber")
    public List<Contato> listByNumero(@RequestParam("numero") String numero){
        return contatoService.listByNumero(numero);
    }

    @PostMapping("/{idPessoa}")
    public Contato create(@PathVariable("idPessoa")@Valid Integer id, @RequestBody @Valid Contato contato) {
        return contatoService.create(id, contato);
    }

    @DeleteMapping("/{idContato}")
    public void delete(@PathVariable("idContato")@Valid Integer id) throws Exception {
        contatoService.delete(id);
    }

    @PutMapping("/{idContato}")
    public Contato update(@PathVariable("idContato") @Valid Integer id, @RequestBody @Valid Contato contatoAtualizar) throws Exception {
        return contatoService.update(id, contatoAtualizar);
    }

}
