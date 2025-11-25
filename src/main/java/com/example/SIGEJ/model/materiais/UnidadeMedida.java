package com.example.SIGEJ.model.materiais;

public class UnidadeMedida {
    private Long id;
    private String sigla;
    private String descricao;

    public UnidadeMedida() {}

    public UnidadeMedida(Long id, String sigla, String descricao) {
        this.id = id;
        this.sigla = sigla;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "UnidadeMedida{" +
                "id=" + id +
                ", sigla='" + sigla + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
