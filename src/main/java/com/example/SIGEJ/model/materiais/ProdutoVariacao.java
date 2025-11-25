package com.example.SIGEJ.model.materiais;

public class ProdutoVariacao {
    private Long id;
    private Produto produto;
    private Cor cor;
    private Tamanho tamanho;
    private String codigoBarras;
    private String codigoInterno;

    public ProdutoVariacao() {}

    public ProdutoVariacao(Long id, Produto produto, Cor cor, Tamanho tamanho, String codigoBarras, String codigoInterno) {
        this.id = id;
        this.produto = produto;
        this.cor = cor;
        this.tamanho = tamanho;
        this.codigoBarras = codigoBarras;
        this.codigoInterno = codigoInterno;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public Tamanho getTamanho() {
        return tamanho;
    }

    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getCodigoInterno() {
        return codigoInterno;
    }

    public void setCodigoInterno(String codigoInterno) {
        this.codigoInterno = codigoInterno;
    }

    @Override
    public String toString() {
        return "ProdutoVariacao{" +
                "id=" + id +
                ", produto=" + produto +
                ", cor=" + cor +
                ", tamanho=" + tamanho +
                ", codigoBarras='" + codigoBarras + '\'' +
                ", codigoInterno='" + codigoInterno + '\'' +
                '}';
    }
}
