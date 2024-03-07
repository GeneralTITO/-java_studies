package br.com.hospital.gerenciamento;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    private List<PacienteModel> pacientes = new ArrayList<>();

    @PostMapping
    public PacienteModel adcionarPacienteModel(@RequestBody PacienteModel paciente){
        pacientes.add(paciente);
        return paciente;
    }

    @GetMapping
    public List<PacienteModel> ListarPacientes(){
        return pacientes;
    }

    @PutMapping("/{id}")
    public PacienteModel atualizarPaciente(@PathVariable UUID id, @RequestBody PacienteModel pacienteAtualizado){
        for (PacienteModel paciente: pacientes){
            if (paciente.getId().equals(id)){
                paciente.setNome(pacienteAtualizado.getNome());
                paciente.setIdade(pacienteAtualizado.getIdade());
                paciente.setEndereco(pacienteAtualizado.getEndereco());
                return paciente;

            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deletarPaciente(@PathVariable UUID id){
        pacientes.removeIf(paciente -> paciente.getId().equals(id));
    }
}
