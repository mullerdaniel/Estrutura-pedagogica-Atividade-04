package com.weg.estrutura.pedagogica.Controller;

import com.weg.estrutura.pedagogica.Dto.Reposta.ProfessorRespostaDto;
import com.weg.estrutura.pedagogica.Dto.Requisicao.ProfessorRequisicaoDto;
import com.weg.estrutura.pedagogica.Service.ProfessorService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @PostMapping
    public ResponseEntity<ProfessorRespostaDto> cadastrar(@RequestBody ProfessorRequisicaoDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(professorService.cadastrarProfessor(dto));
    }

    @GetMapping
    public ResponseEntity<List<ProfessorRespostaDto>> listar() {
        return ResponseEntity.ok(professorService.listarProfessores());
    }
}