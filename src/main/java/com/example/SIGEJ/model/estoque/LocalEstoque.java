package com.example.SIGEJ.model.estoque;

import com.example.SIGEJ.model.rh.Funcionario;

public class LocalEstoque {

    private Long id;
    private String descricao;
    private Funcionario responsavel;

    public LocalEstoque() {}

    public LocalEstoque(Long id, String descricao, Funcionario responsavel) {
        this.id = id;
        this.descricao = descricao;
        this.responsavel = responsavel;
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

    public Funcionario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Funcionario responsavel) {
        this.responsavel = responsavel;
    }

    @Override
    public String toString() {
        return "LocalEstoque{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", responsavel=" + responsavel +
                '}';
    }
}
