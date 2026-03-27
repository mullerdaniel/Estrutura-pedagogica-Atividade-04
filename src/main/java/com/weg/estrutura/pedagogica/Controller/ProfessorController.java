package com.weg.estrutura.pedagogica.Controller;

import com.weg.estrutura.pedagogica.Dto.Reposta.ProfessorRespostaDto;
import com.weg.estrutura.pedagogica.Dto.Requisicao.ProfessorRequisicaoDto;
import com.weg.estrutura.pedagogica.Service.ProfessorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    // cadastrar professor
    @PostMapping
    public ProfessorRespostaDto cadastrar(@RequestBody ProfessorRequisicaoDto dto) {
        return professorService.cadastrarProfessor(dto);
    }

    // listar professores
    @GetMapping
    public List<ProfessorRespostaDto> listar() {
        return professorService.listarProfessores();
    }
}
