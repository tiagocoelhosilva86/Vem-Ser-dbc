package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.dto.DadosPessoaisDTO;
import com.dbc.pessoaapi.dto.PessoaCreateDTO;
import com.dbc.pessoaapi.dto.PessoaDto;
import com.dbc.pessoaapi.service.DadosPessoaisService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;



@RequestMapping("/dados/pessoais")
@Slf4j
@RequiredArgsConstructor
@RestController
@Validated
public class DadosPessoaisController {

   public final DadosPessoaisService dadosPessoaisService;


    @PostMapping
    public DadosPessoaisDTO create(@RequestBody @Valid DadosPessoaisDTO dadosPessoaisDTO) throws Exception {
        log.info("iniciando criação da pessoa");
        DadosPessoaisDTO dadosPessoaisDTO1 = dadosPessoaisService.create(dadosPessoaisDTO);
        log.info("pessoa criada com sucesso");
        return dadosPessoaisDTO1;
    }

    @GetMapping
    public List<DadosPessoaisDTO> list() {
        return dadosPessoaisService.list();
    }
    @GetMapping("/{cpf}")
    public DadosPessoaisDTO getPorCpf(@PathVariable("cpf") String  cpf) {
        return dadosPessoaisService.getPorCpf(cpf);
    }
    @PutMapping("/{cpf}")
    public DadosPessoaisDTO update(@PathVariable("cpf") String  cpf,
                            @RequestBody @Valid DadosPessoaisDTO dadosPessoaisDTOAtualizar) throws Exception {
        return dadosPessoaisService.update(cpf, dadosPessoaisDTOAtualizar);
    }

    @DeleteMapping("/{cpf}")
    public void delete(@PathVariable("cpf") String  cpf){
        dadosPessoaisService.delete(cpf);
    }


}
