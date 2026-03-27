package com.weg.estrutura.pedagogica.Controller;

import com.weg.estrutura.pedagogica.Dto.Reposta.CursoRespostaDto;
import com.weg.estrutura.pedagogica.Dto.Requisicao.CursoRequisicaoDto;
import com.weg.estrutura.pedagogica.Service.CursoService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @PostMapping
    public ResponseEntity<CursoRespostaDto> cadastrar(@RequestBody CursoRequisicaoDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(cursoService.cadastrarCurso(dto));
    }

    @GetMapping
    public ResponseEntity<List<CursoRespostaDto>> listar() {
        return ResponseEntity.ok(cursoService.listarCursos());
    }

    @GetMapping("/professor-nome")
    public ResponseEntity<List<CursoRespostaDto>> buscarPorNome(@RequestParam String nome) {
        return ResponseEntity.ok(cursoService.buscarPorNomeProfessor(nome));
    }

    @GetMapping("/professor/{id}")
    public ResponseEntity<List<CursoRespostaDto>> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(cursoService.buscarPorIdProfessor(id));
    }

    @GetMapping("/titulo")
    public ResponseEntity<List<CursoRespostaDto>> buscarPorTitulo(@RequestParam String titulo) {
        return ResponseEntity.ok(cursoService.buscarPorTitulo(titulo));
    }
}