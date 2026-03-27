package com.weg.estrutura.pedagogica.Mapper;

import com.weg.estrutura.pedagogica.Dto.Reposta.CursoRespostaDto;
import com.weg.estrutura.pedagogica.Dto.Requisicao.CursoRequisicaoDto;
import com.weg.estrutura.pedagogica.Model.Curso;
import com.weg.estrutura.pedagogica.Model.Professor;

public class CursoMapper {

    public static Curso toEntity(CursoRequisicaoDto dto, Professor professor) {
        Curso curso = new Curso();
        curso.setTitulo(dto.getTitulo());
        curso.setProfessor(professor);
        return curso;
    }

    public static CursoRespostaDto toResponse(Curso curso) {
        return new CursoRespostaDto(
                curso.getId(),
                curso.getTitulo(),
                curso.getProfessor().getNome()
        );
    }
}