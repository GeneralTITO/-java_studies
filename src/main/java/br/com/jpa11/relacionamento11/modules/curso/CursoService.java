package br.com.jpa11.relacionamento11.modules.curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public CursoEntity salvarCurso(CursoEntity curso) {
        return cursoRepository.save(curso);
    }

    public List<CursoEntity> listarCursos() {
        return cursoRepository.findAll();
    }

    public Optional<CursoEntity> buscarCursoPorId(Long id) {
        return cursoRepository.findById(id);
    }

    public void deletarCurso(Long id) {
        cursoRepository.deleteById(id);
    }
}