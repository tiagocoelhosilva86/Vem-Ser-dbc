package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.dto.ContatoDTO;
import com.dbc.pessoaapi.entity.Contatoentity;
import com.dbc.pessoaapi.service.ContatoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/contato")
@Validated
@Slf4j
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
    public List<Contatoentity> list() {
        return contatoService.list();
    }

    @GetMapping("/bynumber")
    public List<ContatoDTO> listByNumero(@RequestParam("numero") String numero){
        log.info("Listando contato pelo numero");
        return contatoService.listByNumero(numero);
    }

    @PostMapping("/{idPessoa}")
    public ContatoDTO create(@PathVariable("idPessoa")@Valid Integer id, @RequestBody @Valid ContatoDTO contatoDTO) throws Exception {
        log.info("criado contato");
        ContatoDTO contatoDTO1= contatoService.create(id, contatoDTO);
        log.info("contato criado com sucesso");
        return contatoDTO1;

    }

    @DeleteMapping("/{idContato}")
    public void delete(@PathVariable("idContato")@Valid Integer id) throws Exception {
        log.info("deletando contato");
        contatoService.delete(id);
        log.info("contato deletado com sucesso");
    }

    @PutMapping("/{idContato}")
    public ContatoDTO update(@PathVariable("idContato") @Valid Integer id, @RequestBody @Valid ContatoDTO contatoDTO) throws Exception {
        log.info(" atualizar contato");
        ContatoDTO contatoDTO1= contatoService.update(id, contatoDTO);
        log.info("contato atualizado com sucesso");
        return contatoDTO1;

    }

}
