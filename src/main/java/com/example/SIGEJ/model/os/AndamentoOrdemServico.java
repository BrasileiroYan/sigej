package com.example.SIGEJ.model.os;

import com.example.SIGEJ.model.rh.Funcionario;

import java.time.LocalDateTime;

public class AndamentoOrdemServico {

    private Long id;
    private OrdemServico os;
    private LocalDateTime dataHora;
    private StatusOrdemServico statusAnterior;
    private StatusOrdemServico statusNovo;
    private Funcionario funcionario;
    private String descricao;
    private LocalDateTime inicioAtendimento;
    private LocalDateTime fimAtendimento;

    public AndamentoOrdemServico() {}

    public AndamentoOrdemServico(Long id, OrdemServico os, LocalDateTime dataHora, StatusOrdemServico statusAnterior, StatusOrdemServico statusNovo, Funcionario funcionario, String descricao, LocalDateTime inicioAtendimento, LocalDateTime fimAtendimento) {
        this.id = id;
        this.os = os;
        this.dataHora = dataHora;
        this.statusAnterior = statusAnterior;
        this.statusNovo = statusNovo;
        this.funcionario = funcionario;
        this.descricao = descricao;
        this.inicioAtendimento = inicioAtendimento;
        this.fimAtendimento = fimAtendimento;
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

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public StatusOrdemServico getStatusAnterior() {
        return statusAnterior;
    }

    public void setStatusAnterior(StatusOrdemServico statusAnterior) {
        this.statusAnterior = statusAnterior;
    }

    public StatusOrdemServico getStatusNovo() {
        return statusNovo;
    }

    public void setStatusNovo(StatusOrdemServico statusNovo) {
        this.statusNovo = statusNovo;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getInicioAtendimento() {
        return inicioAtendimento;
    }

    public void setInicioAtendimento(LocalDateTime inicioAtendimento) {
        this.inicioAtendimento = inicioAtendimento;
    }

    public LocalDateTime getFimAtendimento() {
        return fimAtendimento;
    }

    public void setFimAtendimento(LocalDateTime fimAtendimento) {
        this.fimAtendimento = fimAtendimento;
    }

    @Override
    public String toString() {
        return "AndamentoOrdemServico{" +
                "id=" + id +
                ", os=" + os +
                ", dataHora=" + dataHora +
                ", statusAnterior=" + statusAnterior +
                ", statusNovo=" + statusNovo +
                ", funcionario=" + funcionario +
                ", descricao='" + descricao + '\'' +
                ", inicioAtendimento=" + inicioAtendimento +
                ", fimAtendimento=" + fimAtendimento +
                '}';
    }
}
