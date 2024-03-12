package br.com.jpa11.relacionamento11.modules.curso;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.jpa11.relacionamento11.modules.aluno.AlunoEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity
@JsonIgnoreProperties("alunos")
public class CursoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    // Relacionamento N:M com Aluno
    @ManyToMany(mappedBy = "cursos")
    private Set<AlunoEntity> alunos;
}