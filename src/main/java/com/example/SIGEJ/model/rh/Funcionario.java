package com.example.SIGEJ.model.rh;

import java.time.LocalDate;

public class Funcionario {
    private Long id;
    private Pessoa pessoa;
    private Setor setor;
    private TipoFuncionario tipo;
    private LocalDate dataAdmissao;
    private LocalDate dataDemissao;

    public Funcionario() {}
    public Funcionario(Long id, Pessoa pessoa, Setor setor, TipoFuncionario tipo, LocalDate dataAdmissao, LocalDate dataDemissao) {
        this.id = id;
        this.pessoa = pessoa;
        this.setor = setor;
        this.tipo = tipo;
        this.dataAdmissao = dataAdmissao;
        this.dataDemissao = dataDemissao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public TipoFuncionario getTipo() {
        return tipo;
    }

    public void setTipo(TipoFuncionario tipo) {
        this.tipo = tipo;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public LocalDate getDataDemissao() {
        return dataDemissao;
    }

    public void setDataDemissao(LocalDate dataDemissao) {
        this.dataDemissao = dataDemissao;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", pessoa=" + pessoa +
                ", setor=" + setor +
                ", tipo=" + tipo +
                ", dataAdmissao=" + dataAdmissao +
                ", dataDemissao=" + dataDemissao +
                '}';
    }
}
