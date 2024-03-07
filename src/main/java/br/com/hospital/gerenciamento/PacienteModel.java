package br.com.hospital.gerenciamento;

import java.util.UUID;

public class PacienteModel {
    private UUID id;
    private String nome;
    private int idade;
    private String endereco;

    public PacienteModel(String nome, int idade, String endereco) {
        this.id = UUID.randomUUID(); // Gera um UUID ao criar um paciente
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}