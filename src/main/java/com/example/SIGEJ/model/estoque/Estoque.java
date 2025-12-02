package com.example.SIGEJ.model.estoque;

import com.example.SIGEJ.model.materiais.ProdutoVariacao;

public class Estoque {
    private ProdutoVariacao produtoVariacao;
    private LocalEstoque localEstoque;
    private Double quantidade;
    private Double pontoReposicao;

    public Estoque() {}

    public Estoque(ProdutoVariacao produtoVariacao, LocalEstoque localEstoque, Double quantidade, Double pontoReposicao) {
        this.produtoVariacao = produtoVariacao;
        this.localEstoque = localEstoque;
        this.quantidade = quantidade;
        this.pontoReposicao = pontoReposicao;
    }

    public ProdutoVariacao getProdutoVariacao() {
        return produtoVariacao;
    }

    public void setProdutoVariacao(ProdutoVariacao produtoVariacao) {
        this.produtoVariacao = produtoVariacao;
    }

    public LocalEstoque getLocalEstoque() {
        return localEstoque;
    }

    public void setLocalEstoque(LocalEstoque localEstoque) {
        this.localEstoque = localEstoque;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPontoReposicao() {
        return pontoReposicao;
    }

    public void setPontoReposicao(Double pontoReposicao) {
        this.pontoReposicao = pontoReposicao;
    }

    @Override
    public String toString() {
        return "Estoque{" +
                "produtoVariacao=" + produtoVariacao +
                ", localEstoque=" + localEstoque +
                ", quantidade=" + quantidade +
                ", pontoReposicao=" + pontoReposicao +
                '}';
    }
}
