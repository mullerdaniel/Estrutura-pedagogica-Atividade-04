package com.weg.estrutura.pedagogica.Mapper;


import com.weg.estrutura.pedagogica.Dto.Reposta.ProfessorRespostaDto;
import com.weg.estrutura.pedagogica.Dto.Requisicao.ProfessorRequisicaoDto;
import com.weg.estrutura.pedagogica.Model.Professor;

public class ProfessorMapper {

    public static Professor toEntity(ProfessorRequisicaoDto dto) {
        Professor professor = new Professor();
        professor.setNome(dto.getNome());
        professor.setEmail(dto.getEmail());
        return professor;
    }

    public static ProfessorRespostaDto toResponse(Professor professor) {
        return new ProfessorRespostaDto(
                professor.getId(),
                professor.getNome(),
                professor.getEmail()
        );
    }
}