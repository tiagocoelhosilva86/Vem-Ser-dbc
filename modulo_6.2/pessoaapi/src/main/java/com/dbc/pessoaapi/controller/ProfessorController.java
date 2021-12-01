package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.entity.ProfessorEntity;
import com.dbc.pessoaapi.repository.ProfessorRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/professor")
@RequiredArgsConstructor
public class ProfessorController {
    private  final ProfessorRepository repository;

    @GetMapping
    public List<ProfessorEntity> list() {
        return repository.findAll();
    }

    @PostMapping
    public ProfessorEntity create(@RequestBody ProfessorEntity professor ) {
        return repository.save(professor);
    }

}
