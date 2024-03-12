package br.com.jpa11.relacionamento11.modules.aluno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jpa11.relacionamento11.exceptions.ResourceNotFoundException;
import br.com.jpa11.relacionamento11.modules.curso.CursoEntity;
import br.com.jpa11.relacionamento11.modules.curso.CursoService;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private CursoService cursoService;

    @Autowired
    private AlunoRepository alunoRepository;

    public AlunoEntity salvarAluno(AlunoEntity aluno) {
        return alunoRepository.save(aluno);
    }

    public List<AlunoEntity> listarAlunos() {
        return alunoRepository.findAll();
    }

    public Optional<AlunoEntity> buscarAlunoPorId(Long id) {
        return alunoRepository.findById(id);
    }

    public void deletarAluno(Long id) {
        alunoRepository.deleteById(id);
    }

    @Transactional
    public void adicionarCursoAoAluno(Long alunoId, Long cursoId) {
        AlunoEntity aluno = buscarAlunoPorId(alunoId)
                .orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado: " + alunoId));
        CursoEntity curso = cursoService.buscarCursoPorId(cursoId)
                .orElseThrow(() -> new ResourceNotFoundException("Curso não encontrado: " + cursoId));

        aluno.getCursos().add(curso);
        curso.getAlunos().add(aluno);

        alunoRepository.save(aluno);
    }

    @Transactional
    public void removerCursoDoAluno(Long alunoId, Long cursoId) {
        AlunoEntity aluno = buscarAlunoPorId(alunoId)
                .orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado: " + alunoId));
        CursoEntity curso = cursoService.buscarCursoPorId(cursoId)
                .orElseThrow(() -> new ResourceNotFoundException("Curso não encontrado: " + cursoId));

        aluno.getCursos().remove(curso);
        curso.getAlunos().remove(aluno);

        alunoRepository.save(aluno);
    }
}