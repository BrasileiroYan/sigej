package com.example.SIGEJ.model.rh;

public class Setor {
    private Long id;
    private String nome;
    private String sigla;

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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    @Override
    public String toString() {
        return "Setor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sigla='" + sigla + '\'' +
                '}';
    }
}
