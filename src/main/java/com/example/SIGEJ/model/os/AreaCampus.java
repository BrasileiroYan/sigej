package com.example.SIGEJ.model.os;

public class AreaCampus {

    private Long id;
    private TipoAreaCampus tipoArea;
    private String descricao;
    private String bloco;

    public AreaCampus() {}

    public AreaCampus(Long id, TipoAreaCampus tipoArea, String descricao, String bloco) {
        this.id = id;
        this.tipoArea = tipoArea;
        this.descricao = descricao;
        this.bloco = bloco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoAreaCampus getTipoArea() {
        return tipoArea;
    }

    public void setTipoArea(TipoAreaCampus tipoArea) {
        this.tipoArea = tipoArea;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    @Override
    public String toString() {
        return "AreaCampus{" +
                "id=" + id +
                ", tipoArea=" + tipoArea +
                ", descricao='" + descricao + '\'' +
                ", bloco='" + bloco + '\'' +
                '}';
    }
}
