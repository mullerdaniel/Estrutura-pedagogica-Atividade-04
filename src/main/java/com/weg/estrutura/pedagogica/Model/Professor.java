package com.weg.estrutura.pedagogica.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "professor")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_professor", nullable = false)
    private String nome;

    @Column(name = "email_professor", nullable = false)
    private String email;

    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL)
    private List<Curso> cursos;
}