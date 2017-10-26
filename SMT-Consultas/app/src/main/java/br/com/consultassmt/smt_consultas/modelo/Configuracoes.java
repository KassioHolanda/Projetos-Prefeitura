package br.com.consultassmt.smt_consultas.modelo;

import com.orm.SugarRecord;

import java.io.Serializable;

/**
 * Created by Kassio on 13/10/2017.
 */

public class Configuracoes implements Serializable{

    private boolean alertInicial;
    private boolean alertDataHora;

    public Configuracoes(boolean alertInicial, boolean alertDataHora) {
        this.alertInicial = alertInicial;
        this.alertDataHora = alertDataHora;
    }

    public boolean isAlertInicial() {
        return alertInicial;
    }

    public void setAlertInicial(boolean alertInicial) {
        this.alertInicial = alertInicial;
    }

    public boolean isAlertDataHora() {
        return alertDataHora;
    }

    public void setAlertDataHora(boolean alertDataHora) {
        this.alertDataHora = alertDataHora;
    }
}
