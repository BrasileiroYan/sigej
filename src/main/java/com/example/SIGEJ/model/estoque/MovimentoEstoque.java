package com.example.SIGEJ.model.estoque;

import com.example.SIGEJ.model.os.OrdemServico;
import com.example.SIGEJ.model.materiais.ProdutoVariacao;
import com.example.SIGEJ.model.rh.Funcionario;

import java.time.LocalDateTime;

public class MovimentoEstoque {
    private Long id;
    private ProdutoVariacao produtoVariacao;
    private LocalEstoque localEstoque;
    private TipoMovimentoEstoque tipoMovimento;
    private Double quantidade;
    private LocalDateTime dataHora;
    private Funcionario funcionario;
    private OrdemServico ordemServico;
    private String observacao;

    public MovimentoEstoque() {}

    public MovimentoEstoque(Long id, ProdutoVariacao produtoVariacao, LocalEstoque localEstoque, TipoMovimentoEstoque tipoMovimento, Double quantidade, LocalDateTime dataHora, Funcionario funcionario, OrdemServico ordemServico, String observacao) {
        this.id = id;
        this.produtoVariacao = produtoVariacao;
        this.localEstoque = localEstoque;
        this.tipoMovimento = tipoMovimento;
        this.quantidade = quantidade;
        this.dataHora = dataHora;
        this.funcionario = funcionario;
        this.ordemServico = ordemServico;
        this.observacao = observacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public TipoMovimentoEstoque getTipoMovimento() {
        return tipoMovimento;
    }

    public void setTipoMovimento(TipoMovimentoEstoque tipoMovimento) {
        this.tipoMovimento = tipoMovimento;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public OrdemServico getOrdemServico() {
        return ordemServico;
    }

    public void setOrdemServico(OrdemServico ordemServico) {
        this.ordemServico = ordemServico;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public String toString() {
        return "MovimentoEstoque{" +
                "id=" + id +
                ", produtoVariacao=" + produtoVariacao +
                ", localEstoque=" + localEstoque +
                ", tipoMovimento=" + tipoMovimento +
                ", quantidade=" + quantidade +
                ", dataHora=" + dataHora +
                ", funcionario=" + funcionario +
                ", ordemServico=" + ordemServico +
                ", observacao='" + observacao + '\'' +
                '}';
    }
}
