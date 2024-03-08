package br.com.hospital.gerenciamento;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {
    private List<PacienteModel> pacientes = new ArrayList<>();

    @GetMapping("/idade")
    public List<PacienteModel> buscarPorIdade(@RequestParam(value = "idade", required = false) String idade) {
        if (idade != null) {
            return pacientes.stream()
                    .filter(p -> p.getIdade() == Integer.parseInt(idade))
                    .collect(Collectors.toList());
        } else {
            // Se nenhum parâmetro de idade for fornecido, retornar todos os pacientes
            return pacientes;
        }
    }

    @PostMapping
    public PacienteModel adcionarPacienteModel(@RequestBody PacienteModel paciente) {
        pacientes.add(paciente);
        return paciente;
    }

    @GetMapping
    public List<PacienteModel> ListarPacientes() {
        return pacientes;
    }

    @GetMapping("/{id}")
    public Optional<PacienteModel> ListarPacientesPorId(@PathVariable UUID pacienteId) {
        return pacientes.stream().filter(p -> p.getId().equals(pacienteId)).findFirst();
    }

    @PutMapping("/{id}")
    public PacienteModel atualizarPaciente(@PathVariable UUID id, @RequestBody PacienteModel pacienteAtualizado) {
        for (PacienteModel paciente : pacientes) {
            if (paciente.getId().equals(id)) {
                paciente.setNome(pacienteAtualizado.getNome());
                paciente.setIdade(pacienteAtualizado.getIdade());
                paciente.setEndereco(pacienteAtualizado.getEndereco());
                return paciente;

            }
        }
        return null;
    }

    @PutMapping("/{pacienteId}")
    public Optional<PacienteModel> update(@PathVariable UUID pacienteId,
            @RequestBody PacienteModel payload) {
        var novosPacientes = pacientes.stream().map(p -> {
            if (p.getId().equals(pacienteId)) {
                payload.setId(p.getId());
                return payload;
            }
            return p;
        });

        pacientes = new ArrayList<>(novosPacientes.toList());
        return pacientes.stream()
                .filter(p -> p.getId().equals(pacienteId))
                .findFirst();
    }

    @DeleteMapping("/{id}")
    public void deletarPaciente(@PathVariable UUID id) {
        pacientes.removeIf(paciente -> paciente.getId().equals(id));
    }

    @DeleteMapping("/{pacienteId}")
    public void delete(@PathVariable UUID pacienteId) {
        var novosPacientes = pacientes.stream().filter(p -> !p.getId().equals(pacienteId));
        pacientes = new ArrayList<>(novosPacientes.toList());
    }
}
