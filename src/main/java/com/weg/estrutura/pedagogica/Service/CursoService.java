package com.weg.estrutura.pedagogica.Service;

import com.weg.estrutura.pedagogica.Dto.Reposta.CursoRespostaDto;
import com.weg.estrutura.pedagogica.Dto.Requisicao.CursoRequisicaoDto;
import com.weg.estrutura.pedagogica.Mapper.CursoMapper;
import com.weg.estrutura.pedagogica.Model.Curso;
import com.weg.estrutura.pedagogica.Model.Professor;
import com.weg.estrutura.pedagogica.Repository.CursoRepository;
import com.weg.estrutura.pedagogica.Repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;
    private final ProfessorRepository professorRepository;

    public CursoService(CursoRepository cursoRepository,
                        ProfessorRepository professorRepository) {
        this.cursoRepository = cursoRepository;
        this.professorRepository = professorRepository;
    }

    // cadastrar curso
    public CursoRespostaDto cadastrarCurso(CursoRequisicaoDto dto) {

        Professor professor = professorRepository.findById(dto.getProfessorId())
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));

        Curso curso = CursoMapper.toEntity(dto, professor);
        curso = cursoRepository.save(curso);

        return CursoMapper.toResponse(curso);
    }

    // listar cursos
    public List<CursoRespostaDto> listarCursos() {
        return cursoRepository.findAll()
                .stream()
                .map(CursoMapper::toResponse)
                .collect(Collectors.toList());
    }

    // buscar por nome do professor
    public List<CursoRespostaDto> buscarPorNomeProfessor(String nome) {
        return cursoRepository.findByProfessorNome(nome)
                .stream()
                .map(CursoMapper::toResponse)
                .collect(Collectors.toList());
    }

    // buscar por id do professor
    public List<CursoRespostaDto> buscarPorIdProfessor(Long id) {
        return cursoRepository.findByProfessorId(id)
                .stream()
                .map(CursoMapper::toResponse)
                .collect(Collectors.toList());
    }

    // buscar por título do curso
    public List<CursoRespostaDto> buscarPorTitulo(String titulo) {
        return cursoRepository.findByTitulo(titulo)
                .stream()
                .map(CursoMapper::toResponse)
                .collect(Collectors.toList());
    }
}