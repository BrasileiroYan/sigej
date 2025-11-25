package com.example.SIGEJ.model.materiais;

public class Produto {
    private Long id;
    private String descricao;
    private CategoriaMaterial categoria;
    private UnidadeMedida unidadeMedida;
    private Marca marca;

    public Produto() {}

    public Produto(Long id, String descricao, CategoriaMaterial categoria, UnidadeMedida unidadeMedida, Marca marca) {
        this.id = id;
        this.descricao = descricao;
        this.categoria = categoria;
        this.unidadeMedida = unidadeMedida;
        this.marca = marca;
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

    public CategoriaMaterial getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaMaterial categoria) {
        this.categoria = categoria;
    }

    public UnidadeMedida getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", categoria=" + categoria +
                ", unidadeMedida=" + unidadeMedida +
                ", marca=" + marca +
                '}';
    }
}
