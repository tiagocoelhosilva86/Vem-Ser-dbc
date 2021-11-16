package com.dbc.pessoaapi.controller;


import com.dbc.pessoaapi.entity.Contatoentity;
import com.dbc.pessoaapi.entity.Enderecoentity;
import com.dbc.pessoaapi.repository.ContatoRepository;
import com.dbc.pessoaapi.repository.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paginacao")
@RequiredArgsConstructor
public class PaginacaoController {

    private  final ContatoRepository  contatoRepository;
    @GetMapping("/lista-contato-ordenado-contato")
    public Page<Contatoentity> listaOrdenadaContato(
            @RequestParam Integer pagina,
            @RequestParam Integer quantidadeDeRegistrosPorPagina ){
        Pageable pageable = PageRequest.of(pagina,
                quantidadeDeRegistrosPorPagina,
                Sort.by("descricao"));
        Page<Contatoentity> contato = contatoRepository.findAll(pageable);
        return contato;

    }
    private  final EnderecoRepository  enderecoRepository;
    @GetMapping("/lista-ordenado-cep")
    public Page<Enderecoentity> listaOrdenadaCep(
            @RequestParam Integer pagina,
            @RequestParam Integer quantidadeDeRegistrosPorPagina ) {

            Pageable pageable = PageRequest.of(pagina,
                    quantidadeDeRegistrosPorPagina,
                    Sort.by("Cep"));
            Page<Enderecoentity> endereco = enderecoRepository.findAll(pageable);
            return endereco;

    }
    @GetMapping("/enderecos-por-pais")
    public Page<Contatoentity> enderecosPorPais(
            @RequestParam Integer pagina,
            @RequestParam Integer qtdRegistrosPagina,
            @RequestParam String pais ) {
        Pageable pageable = PageRequest.of(pagina, qtdRegistrosPagina);
        return enderecoRepository.findByPais(pais, pageable);
    }
}
