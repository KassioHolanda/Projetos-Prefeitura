package br.com.consultassmt.smt_consultas.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import br.com.consultassmt.smt_consultas.R;
import br.com.consultassmt.smt_consultas.adapter.AdapterMinhasSolicitacoes;
import br.com.consultassmt.smt_consultas.utils.CarregarSolicitacaoUtils;

public class MinhasSolicitacoesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CardView cardViewSolicitacao;
    private TextView nomeEmpresa;
    private ProgressDialog load;
    private TextView observacao;
    private TextView statusSolicitacao;
    private TextView solicitanteSolicitacao;
    private CarregarSolicitacaoUtils carregarSolicitacaoUtils;
    private String cpfConsulta;
    private String cnpjConsulta;
    private TextView dataCadastro;
    private AdapterMinhasSolicitacoes adapterMinhasSolicitacoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minhas_solicitacoes);

        recyclerView = findViewById(R.id.recycler_view_minhas_solicitacoes_id);
        nomeEmpresa = findViewById(R.id.empresa_id);
        observacao = findViewById(R.id.observacao_id);
        solicitanteSolicitacao = findViewById(R.id.solicitante_solicitacao_id);
        dataCadastro = findViewById(R.id.data_cadastro_id);

        Intent intentConsulta = getIntent();
        cpfConsulta = intentConsulta.getStringExtra("cpfConsulta");
        cnpjConsulta = intentConsulta.getStringExtra("cnpjConsulta");
    }

    @Override
    protected void onResume() {
        super.onResume();


    }

}
