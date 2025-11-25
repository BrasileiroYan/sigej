package com.example.SIGEJ.model.rh;

public class EquipeManutencao {
    private Long id;
    private String nome;
    private String turno;

    public EquipeManutencao() {}

    public EquipeManutencao(Long id, String nome, String turno) {
        this.id = id;
        this.nome = nome;
        this.turno = turno;
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

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
}
