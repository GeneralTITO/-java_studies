package br.com.jpa11.relacionamento11.modules.aluno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public ResponseEntity<AlunoEntity> criarAluno(@RequestBody AlunoEntity aluno) {
        return ResponseEntity.ok(alunoService.salvarAluno(aluno));
    }

    @GetMapping
    public ResponseEntity<List<AlunoEntity>> listarAlunos() {
        return ResponseEntity.ok(alunoService.listarAlunos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoEntity> buscarAlunoPorId(@PathVariable Long id) {
        return alunoService.buscarAlunoPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAluno(@PathVariable Long id) {
        alunoService.deletarAluno(id);
        return ResponseEntity.noContent().build();
    }


    @PostMapping("/{alunoId}/adicionar_curso/{cursoId}")
    public ResponseEntity<Void> adicionarCursoAoAluno(@PathVariable Long alunoId, @PathVariable Long cursoId) {
        alunoService.adicionarCursoAoAluno(alunoId, cursoId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{alunoId}/remover-curso/{cursoId}")
    public ResponseEntity<Void> removerCursoDoAluno(@PathVariable Long alunoId, @PathVariable Long cursoId) {
        alunoService.removerCursoDoAluno(alunoId, cursoId);
        return ResponseEntity.ok().build();
    }
    
}