package com.weg.estrutura.pedagogica.Repository;

import com.weg.estrutura.pedagogica.Model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository <Professor, Long> {
}
