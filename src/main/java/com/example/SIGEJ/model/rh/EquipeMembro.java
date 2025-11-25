package com.example.SIGEJ.model.rh;

import java.time.LocalDate;

public class EquipeMembro {

    private Long id;
    private EquipeManutencao equipe;
    private Funcionario funcionario;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private String funcao;

    public EquipeMembro() {}

    public EquipeMembro(Long id, EquipeManutencao equipe, Funcionario funcionario, LocalDate dataInicio, LocalDate dataFim, String funcao) {
        this.id = id;
        this.equipe = equipe;
        this.funcionario = funcionario;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.funcao = funcao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EquipeManutencao getEquipe() {
        return equipe;
    }

    public void setEquipe(EquipeManutencao equipe) {
        this.equipe = equipe;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    @Override
    public String toString() {
        return "EquipeMembro{" +
                "id=" + id +
                ", equipe=" + equipe +
                ", funcionario=" + funcionario +
                ", dataInicio=" + dataInicio +
                ", dataFim=" + dataFim +
                ", funcao='" + funcao + '\'' +
                '}';
    }
}
