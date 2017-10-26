package br.com.consultassmt.smt_consultas.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.consultassmt.smt_consultas.R;
import br.com.consultassmt.smt_consultas.adapter.AdapterObservacoes;
import br.com.consultassmt.smt_consultas.modelo.Observacao;
import br.com.consultassmt.smt_consultas.modelo.Solicitacao;
import br.com.consultassmt.smt_consultas.utils.CarregarSolicitacaoUtils;

public class HistoricoEtapasActivity extends AppCompatActivity {

    private RecyclerView recyclerViewObservacoes;
    private ProgressDialog load;
    private String cpfConsulta;
    private String cnpjConsulta;
    private String numeroSolicitacaoConsulta;
    private Solicitacao solicitacao;
    private CarregarSolicitacaoUtils carregarSolicitacaoUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico_etapas);

        recyclerViewObservacoes = findViewById(R.id.recycler_view_observacoes_id);

        Intent intentConsulta = getIntent();

        cpfConsulta = intentConsulta.getStringExtra("cpfConsulta");
        cnpjConsulta = intentConsulta.getStringExtra("cnpjConsulta");
        numeroSolicitacaoConsulta = intentConsulta.getStringExtra("numeroSolicitacaoConsulta");
        carregarSolicitacaoUtils = (CarregarSolicitacaoUtils) intentConsulta.getSerializableExtra("solicitacaoUtils");
    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            AdapterObservacoes adapterObservacoes = new AdapterObservacoes(this, inverterLista(carregarSolicitacaoUtils.getListaObservacoes()));
            recyclerViewObservacoes.setAdapter(adapterObservacoes);
            recyclerViewObservacoes.setLayoutManager(new LinearLayoutManager(this));
        } catch (NullPointerException e) {
            Toast.makeText(getApplicationContext(), "Ocorreu um erro, tente novamente", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
//            finish();
        }
    }

    public List<Observacao> inverterLista(List<Observacao> lista) {
        List<Observacao> novaLista = new ArrayList<>();
        for (int i = lista.size() - 1; i >= 0; i--) {
            novaLista.add(lista.get(i));
        }
        return novaLista;
    }
}
