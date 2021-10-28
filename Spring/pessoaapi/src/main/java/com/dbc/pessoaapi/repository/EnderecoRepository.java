package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.entity.Contato;
import com.dbc.pessoaapi.entity.Endereco;
import com.dbc.pessoaapi.entity.Pessoa;
import com.dbc.pessoaapi.entity.TipoEndereco;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class EnderecoRepository {
    private static List<Endereco> enderecoList = new ArrayList<Endereco>();
    private AtomicInteger COUNTERPESSOA = new AtomicInteger();
    private AtomicInteger COUNTERPESSOAENDERECO = new AtomicInteger();


    public EnderecoRepository() {

        enderecoList.add(new Endereco(COUNTERPESSOAENDERECO.incrementAndGet(), COUNTERPESSOA.incrementAndGet(),TipoEndereco.RESIDENCIAL,"logradouro",4,"proximo ão mercado","54705-200","são lourenço da mata","Pernanbuco","Brasil"));

    }
    public Endereco create(Integer idPessoa, Endereco endereco) {
        endereco.setIdPessoa(idPessoa);
        enderecoList.add(endereco);
        return endereco;
    }
    public Endereco update(Integer id, Endereco endereco) throws Exception {
        Endereco endereco1Alterado = enderecoList.stream()
                .filter(x -> x.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato não econtrada"));
        endereco1Alterado.setTipo(endereco.getTipo());
        endereco1Alterado.setCep(endereco.getCep());
        endereco1Alterado.setNumero(endereco.getNumero());
        endereco1Alterado.setCidade(endereco.getCidade());
        endereco1Alterado.setComplemento(endereco.getComplemento());
        endereco1Alterado.setEstado(endereco.getEstado());
        endereco1Alterado.setPais(endereco.getPais());
        endereco1Alterado.setComplemento(endereco.getComplemento());
        endereco1Alterado.setLogradouro(endereco.getLogradouro());

        return endereco1Alterado;
    }
    public List<Endereco> list() {
        return enderecoList;
    }
    public List<Endereco> listById(Integer id) {
        return enderecoList.stream()
                .filter(x -> x.getId().equals(id))
                .collect(Collectors.toList());
    }

    public List<Endereco> listByIdPessoa(Integer idPessoa) {
        return enderecoList.stream()
                .filter(x -> x.getIdPessoa().equals(idPessoa))
                .collect(Collectors.toList());
    }
    public Endereco listByIdpessoa(Integer idpessoa) throws Exception {
        return enderecoList.stream()
                .filter(x -> x.getIdPessoa().equals(idpessoa))
                .findFirst()
                .orElseThrow(() -> new Exception("endereco não encontrado"));
    }
    public void delete(Integer id) throws Exception {
        Endereco enderecoRecuperado = enderecoList.stream()
                .filter(pessoa -> pessoa.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("endereço não econtrada"));
        enderecoList.remove(enderecoRecuperado);
    }


}
