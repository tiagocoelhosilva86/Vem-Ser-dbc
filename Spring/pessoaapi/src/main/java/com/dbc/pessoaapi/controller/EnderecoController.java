package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.entity.Endereco;
import com.dbc.pessoaapi.entity.Pessoa;
import com.dbc.pessoaapi.service.EnderecoService;
import com.dbc.pessoaapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/Endereco")
@Validated
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;


    @PostMapping("/{idPessoa}")
    public Endereco create(@PathVariable("idPessoa") @Valid Integer idPessoa, @RequestBody  @Valid Endereco endereco) throws  Exception {
        return  enderecoService.create(idPessoa, endereco);
    }

    @GetMapping
    public List<Endereco> List(){return enderecoService.list();}

    @GetMapping("/{idPessoa}/pessoa")
    public List<Endereco> listByPessoa(@PathVariable("idPessoa")Integer idPessoa){
        return enderecoService.listByIdPessoa(idPessoa);
    }

    @GetMapping("/{id}")
    public List<Endereco> listById(@PathVariable("id")Integer id){
        return enderecoService.listById(id);
    }

    @PutMapping("/{id}")
    public Endereco update(@PathVariable("id")@Valid Integer id,
                         @RequestBody @Valid Endereco enderecoAtualizar) throws Exception {
        return enderecoService.update(id, enderecoAtualizar);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable ("id") @Valid Integer id) throws Exception {
        enderecoService.delete(id);

    }

}
