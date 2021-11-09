package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.client.DadosPessoaisClient;
import com.dbc.pessoaapi.dto.DadosPessoaisDTO;
import com.dbc.pessoaapi.dto.PessoaCreateDTO;
import com.dbc.pessoaapi.dto.PessoaDto;
import com.dbc.pessoaapi.entity.Pessoaentity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DadosPessoaisService {

    public final  DadosPessoaisClient dadosPessoaisClient;

public DadosPessoaisDTO create(DadosPessoaisDTO dadosPessoaisDTO){

   return dadosPessoaisClient.create(dadosPessoaisDTO);
}


    public List<DadosPessoaisDTO> list() {
   return dadosPessoaisClient.listar();
    }


    public DadosPessoaisDTO getPorCpf ( String  cpf){
       return dadosPessoaisClient.getPorCpf(cpf);
    }

    public DadosPessoaisDTO update( String  cpf,
                            DadosPessoaisDTO dadosPessoaisDTO) throws Exception {
        return dadosPessoaisClient.put(cpf, dadosPessoaisDTO);
    }

    public void delete ( String  cpf){
    dadosPessoaisClient.delete(cpf);
    }
}
