package com.example.SIGEJ.model.os;

public class StatusOrdemServico {
    private Long id;
    private String descricao;

    public StatusOrdemServico() {
    }

    public StatusOrdemServico(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "StatusOrdemServico{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
