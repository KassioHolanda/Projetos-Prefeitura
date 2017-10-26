package br.com.consultassmt.smt_consultas.modelo;

import java.util.Calendar;

/**
 * Created by Kassio on 02/10/2017.
 */

public class Observacao {
    private String observacao;
    private String status;
    private String usuario;
    private Calendar dataHora;
    private String orgao;
    private String setor;

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getDataHora() {
        return " " + dataHora.get(Calendar.HOUR_OF_DAY) + ":" + dataHora.get(Calendar.MINUTE) + ":" + dataHora.get(Calendar.SECOND) + "\n" +
                dataHora.get(Calendar.DAY_OF_MONTH) + "/" + dataHora.get(Calendar.MONTH) + "/" + dataHora.get(Calendar.YEAR);
    }

    public void setDataHora(Calendar dataHora) {
        this.dataHora = dataHora;
    }

    public String getOrgao() {
        return orgao;
    }

    public void setOrgao(String orgao) {
        this.orgao = orgao;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

}
