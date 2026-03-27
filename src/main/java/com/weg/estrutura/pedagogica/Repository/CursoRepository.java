package com.weg.estrutura.pedagogica.Repository;

import com.weg.estrutura.pedagogica.Model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CursoRepository extends JpaRepository<Curso, Long> {

    List<Curso> findByProfessorNome(String nome);

    List<Curso> findByProfessorId(Long id);

    List<Curso> findByTitulo(String titulo);
}