package com.example.SIGEJ.model.materiais;

public class CategoriaMaterial {
    private Long id;
    private String nome;

    public CategoriaMaterial() {
    }

    public CategoriaMaterial(Long id, String nome) {
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
        return "CategoriaMaterial{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
