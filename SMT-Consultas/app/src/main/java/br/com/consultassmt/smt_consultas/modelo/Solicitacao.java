package br.com.consultassmt.smt_consultas.modelo;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Kassio on 28/09/2017.
 */

public class Solicitacao {
    private Long id;
    private String solicitante;
    private String cpf;
    private String empresa;
    private String cnpj;
    private String orgao;
    private List<Observacao> observacoes;
    private List<Observacao> observacoesMeioAmbiente;
    private List<Observacao> observacoesVigilancia;
    private List<Observacao> observacoesSduAcessibilidade;
    private List<Observacao> observacoesSduConsultaPrevia;
    private String numeroSolicitacao;
    private String observacaoSolicitacao;
    private String status;
    private String dataCadastro;

    public Solicitacao() {
        observacoes = new ArrayList<>();
        observacoesMeioAmbiente = new ArrayList<>();
        observacoesSduAcessibilidade = new ArrayList<>();
        observacoesVigilancia = new ArrayList<>();
        observacoesSduConsultaPrevia = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNumeroSolicitacao() {
        return numeroSolicitacao;
    }

    public void setNumeroSolicitacao(String numeroSolicitacao) {
        this.numeroSolicitacao = numeroSolicitacao;
    }

    public String getObservacaoSolicitacao() {
        return observacaoSolicitacao;
    }

    public void setObservacaoSolicitacao(String observacaoSolicitacao) {
        this.observacaoSolicitacao = observacaoSolicitacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public List<Observacao> getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(List<Observacao> observacoes) {
        this.observacoes = observacoes;
    }

    public String getOrgao() {
        return orgao;
    }

    public void setOrgao(String orgao) {
        this.orgao = orgao;
    }

    public List<Observacao> getObservacoesMeioAmbiente() {
        return observacoesMeioAmbiente;
    }

    public List<Observacao> getObservacoesVigilancia() {
        return observacoesVigilancia;
    }

    public List<Observacao> getObservacoesSduAcessibilidade() {
        return observacoesSduAcessibilidade;
    }

    public List<Observacao> getObservacoesSduConsultaPrevia() {
        return observacoesSduConsultaPrevia;
    }
}

