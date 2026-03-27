package com.weg.estrutura.pedagogica.Service;

import com.weg.estrutura.pedagogica.Dto.Reposta.ProfessorRespostaDto;
import com.weg.estrutura.pedagogica.Dto.Requisicao.ProfessorRequisicaoDto;
import com.weg.estrutura.pedagogica.Mapper.ProfessorMapper;
import com.weg.estrutura.pedagogica.Model.Professor;
import com.weg.estrutura.pedagogica.Repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    // cadastrar professor
    public ProfessorRespostaDto cadastrarProfessor(ProfessorRequisicaoDto dto) {
        Professor professor = ProfessorMapper.toEntity(dto);
        professor = professorRepository.save(professor);
        return ProfessorMapper.toResponse(professor);
    }

    // listar professores
    public List<ProfessorRespostaDto> listarProfessores() {
        return professorRepository.findAll()
                .stream()
                .map(ProfessorMapper::toResponse)
                .collect(Collectors.toList());
    }

}