package br.com.consultassmt.smt_consultas.utils;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.consultassmt.smt_consultas.modelo.Observacao;
import br.com.consultassmt.smt_consultas.modelo.Solicitacao;

import static android.content.ContentValues.TAG;

/**
 * Created by Kassio on 28/09/2017.
 */

public class CarregarSolicitacaoUtils implements Serializable {
    private static Solicitacao solicitacao;

    public CarregarSolicitacaoUtils() {
        solicitacao = new Solicitacao();
        //nothing
    }

    public Solicitacao getInformacao(String end) {
        String json;
        Solicitacao retorno;
        json = ApiUtils.getJsonFromApi(end);
        Log.i("Resultado", json);
        retorno = parseJson(json);
        return retorno;
    }

    private Solicitacao parseJson(String json) {
        try {
            JSONObject arraySol = new JSONObject(json);

            solicitacao.setSolicitante(arraySol.getString("cpf"));
            solicitacao.setEmpresa(arraySol.getString("empresa"));
            solicitacao.setCnpj(arraySol.getString("cnpj"));

            JSONArray array = arraySol.getJSONArray("historicos");

            for (int i = 0; i < array.length(); i++) {
                JSONObject observacoes = array.getJSONObject(i);
                Observacao observacao = new Observacao();
                observacao.setUsuario(observacoes.getString("usuario"));
                observacao.setDataHora(CastingToCalendar(observacoes.getString("dataHora")));
                observacao.setStatus(observacoes.getString("status").replace("_", " "));
                if (observacoes.getString("observacao") != null) {
                    observacao.setObservacao(observacoes.getString("observacao").replace("_", " ").replace("  ", " "));
                } else if (observacoes.getString("observacao").equals("")) {
                    observacao.setObservacao("Aguardando analise do setor");
                } else {
                    observacao.setObservacao("Aguardando analise do setor");
                }
                observacao.setSetor(observacoes.getString("setor"));
                observacao.setOrgao(observacoes.getString("orgao"));

                if (observacao.getOrgao().equals("SECRETARIA MUNICIPAL DE DESENVOLVIMENTO URBANO CENTRO NORTE")) {
                    if (observacao.getSetor().equals("CONSULTA PREVIA")) {
                        solicitacao.getObservacoesSduConsultaPrevia().add(observacao);
                        solicitacao.getObservacoes().add(observacao);
                    } else {
                        solicitacao.getObservacoesSduAcessibilidade().add(observacao);
                        solicitacao.getObservacoes().add(observacao);
                    }
                } else if (observacao.getOrgao().equals("SECRETARIA MUNICIPAL DE DESENVOLVIMENTO URBANO CENTRO NORTE")) {

                } else if (observacao.getOrgao().equals("SECRETARIA MUNICIPAL DE MEIO AMBIENTE")) {
                    solicitacao.getObservacoesMeioAmbiente().add(observacao);
                } else {
                    solicitacao.getObservacoesVigilancia().add(observacao);
                }
            }

            return solicitacao;

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Solicitacao getSolicitacao() {
        return solicitacao;
    }

    public static List<Observacao> getListaObservacoes() {
        return solicitacao.getObservacoes();
    }

    public Calendar CastingToCalendar(String date){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(sdf.parse(date));
            return calendar;
        }catch(Exception e){
            Log.d(TAG, "CastingToCalendar: Error");
        }
        return null;
    }
}
