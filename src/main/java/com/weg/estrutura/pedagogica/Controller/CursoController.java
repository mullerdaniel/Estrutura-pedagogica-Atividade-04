package com.weg.estrutura.pedagogica.Controller;

import com.weg.estrutura.pedagogica.Dto.Reposta.CursoRespostaDto;
import com.weg.estrutura.pedagogica.Dto.Requisicao.CursoRequisicaoDto;
import com.weg.estrutura.pedagogica.Service.CursoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    // cadastrar curso
    @PostMapping
    public CursoRespostaDto cadastrar(@RequestBody CursoRequisicaoDto dto) {
        return cursoService.cadastrarCurso(dto);
    }

    // listar cursos
    @GetMapping
    public List<CursoRespostaDto> listar() {
        return cursoService.listarCursos();
    }

    // buscar por nome do professor
    @GetMapping("/professor-nome")
    public List<CursoRespostaDto> buscarPorNome(@RequestParam String nome) {
        return cursoService.buscarPorNomeProfessor(nome);
    }

    // buscar por id do professor
    @GetMapping("/professor/{id}")
    public List<CursoRespostaDto> buscarPorId(@PathVariable Long id) {
        return cursoService.buscarPorIdProfessor(id);
    }

    // buscar por título do curso
    @GetMapping("/titulo")
    public List<CursoRespostaDto> buscarPorTitulo(@RequestParam String titulo) {
        return cursoService.buscarPorTitulo(titulo);
    }
}