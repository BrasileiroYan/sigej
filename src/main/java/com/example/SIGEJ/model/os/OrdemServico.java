package com.example.SIGEJ.model.os;

import com.example.SIGEJ.model.rh.EquipeManutencao;
import com.example.SIGEJ.model.rh.Funcionario;
import com.example.SIGEJ.model.rh.Pessoa;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class OrdemServico {

    private Long id;
    private String numeroSequencial;

    private Pessoa solicitante;
    private AreaCampus areaCampus;
    private TipoOrdemServico tipoOs;
    private EquipeManutencao equipe;
    private Funcionario lider;
    private StatusOrdemServico status;

    private Integer prioridade;
    private LocalDateTime dataAbertura;
    private LocalDate dataPrevista;
    private String descricaoProblema;

    public OrdemServico() {
    }

    public OrdemServico(Long id, String numeroSequencial, Pessoa solicitante, AreaCampus areaCampus, TipoOrdemServico tipoOs, EquipeManutencao equipe, Funcionario lider, StatusOrdemServico status, Integer prioridade, LocalDateTime dataAbertura, LocalDate dataPrevista, String descricaoProblema) {
        this.id = id;
        this.numeroSequencial = numeroSequencial;
        this.solicitante = solicitante;
        this.areaCampus = areaCampus;
        this.tipoOs = tipoOs;
        this.equipe = equipe;
        this.lider = lider;
        this.status = status;
        this.prioridade = prioridade;
        this.dataAbertura = dataAbertura;
        this.dataPrevista = dataPrevista;
        this.descricaoProblema = descricaoProblema;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroSequencial() {
        return numeroSequencial;
    }

    public void setNumeroSequencial(String numeroSequencial) {
        this.numeroSequencial = numeroSequencial;
    }

    public Pessoa getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Pessoa solicitante) {
        this.solicitante = solicitante;
    }

    public AreaCampus getAreaCampus() {
        return areaCampus;
    }

    public void setAreaCampus(AreaCampus areaCampus) {
        this.areaCampus = areaCampus;
    }

    public TipoOrdemServico getTipoOs() {
        return tipoOs;
    }

    public void setTipoOs(TipoOrdemServico tipoOs) {
        this.tipoOs = tipoOs;
    }

    public EquipeManutencao getEquipe() {
        return equipe;
    }

    public void setEquipe(EquipeManutencao equipe) {
        this.equipe = equipe;
    }

    public Funcionario getLider() {
        return lider;
    }

    public void setLider(Funcionario lider) {
        this.lider = lider;
    }

    public StatusOrdemServico getStatus() {
        return status;
    }

    public void setStatus(StatusOrdemServico status) {
        this.status = status;
    }

    public Integer getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Integer prioridade) {
        this.prioridade = prioridade;
    }

    public LocalDateTime getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDateTime dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDate getDataPrevista() {
        return dataPrevista;
    }

    public void setDataPrevista(LocalDate dataPrevista) {
        this.dataPrevista = dataPrevista;
    }

    public String getDescricaoProblema() {
        return descricaoProblema;
    }

    public void setDescricaoProblema(String descricaoProblema) {
        this.descricaoProblema = descricaoProblema;
    }

    @Override
    public String toString() {
        return "OrdemServico{" +
                "id=" + id +
                ", numeroSequencial='" + numeroSequencial + '\'' +
                ", solicitante=" + solicitante +
                ", areaCampus=" + areaCampus +
                ", tipoOs=" + tipoOs +
                ", equipe=" + equipe +
                ", lider=" + lider +
                ", status=" + status +
                ", prioridade=" + prioridade +
                ", dataAbertura=" + dataAbertura +
                ", dataPrevista=" + dataPrevista +
                ", descricaoProblema='" + descricaoProblema + '\'' +
                '}';
    }
}
