package com.example.SIGEJ.model.estoque;

public class TipoMovimentoEstoque {
    private Long id;
    private String descricao;
    private String sinal;

    public TipoMovimentoEstoque(){}

    public TipoMovimentoEstoque(Long id, String descricao, String sinal) {
        this.id = id;
        this.descricao = descricao;
        this.sinal = sinal;
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

    public String getSinal() {
        return sinal;
    }

    public void setSinal(String sinal) {
        this.sinal = sinal;
    }

    @Override
    public String toString() {
        return "TipoMovimentoEstoque{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", sinal='" + sinal + '\'' +
                '}';
    }
}