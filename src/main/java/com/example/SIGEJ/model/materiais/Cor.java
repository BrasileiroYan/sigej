package com.example.SIGEJ.model.materiais;

public class Cor {
    private Long id;
    private String nome;

    public Cor() {}

    public Cor(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Cor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
