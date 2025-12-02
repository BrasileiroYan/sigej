package com.example.SIGEJ.model.os;

import com.example.SIGEJ.model.materiais.ProdutoVariacao;

public class ItemOrdemServico {

    private Long id;
    private OrdemServico os;
    private ProdutoVariacao produtoVariacao;
    private Double quantidadePrevista;
    private Double quantidadeUsada;

    public ItemOrdemServico() {
    }

    public ItemOrdemServico(Long id, OrdemServico os, ProdutoVariacao produtoVariacao, Double quantidadePrevista, Double quantidadeUsada) {
        this.id = id;
        this.os = os;
        this.produtoVariacao = produtoVariacao;
        this.quantidadePrevista = quantidadePrevista;
        this.quantidadeUsada = quantidadeUsada;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrdemServico getOs() {
        return os;
    }

    public void setOs(OrdemServico os) {
        this.os = os;
    }

    public ProdutoVariacao getProdutoVariacao() {
        return produtoVariacao;
    }

    public void setProdutoVariacao(ProdutoVariacao produtoVariacao) {
        this.produtoVariacao = produtoVariacao;
    }

    public Double getQuantidadePrevista() {
        return quantidadePrevista;
    }

    public void setQuantidadePrevista(Double quantidadePrevista) {
        this.quantidadePrevista = quantidadePrevista;
    }

    public Double getQuantidadeUsada() {
        return quantidadeUsada;
    }

    public void setQuantidadeUsada(Double quantidadeUsada) {
        this.quantidadeUsada = quantidadeUsada;
    }

    @Override
    public String toString() {
        return "ItemOrdemServico{" +
                "id=" + id +
                ", os=" + os +
                ", produtoVariacao=" + produtoVariacao +
                ", quantidadePrevista=" + quantidadePrevista +
                ", quantidadeUsada=" + quantidadeUsada +
                '}';
    }
}
