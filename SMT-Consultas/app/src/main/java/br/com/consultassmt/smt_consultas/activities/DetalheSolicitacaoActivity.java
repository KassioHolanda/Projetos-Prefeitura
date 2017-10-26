package br.com.consultassmt.smt_consultas.activities;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import br.com.consultassmt.smt_consultas.R;
import br.com.consultassmt.smt_consultas.modelo.Configuracoes;
import br.com.consultassmt.smt_consultas.modelo.Solicitacao;
import br.com.consultassmt.smt_consultas.utils.CarregarSolicitacaoUtils;

public class DetalheSolicitacaoActivity extends AppCompatActivity {
    private TextView razaoSocialEmpresa;
    private TextView numeroSolicitacao;
    private TextView statusSolicitacao;
    private TextView cnpjEmpresaSolicitacao;
    private RecyclerView recyclerView;

    CarregarSolicitacaoUtils carregarSolicitacaoUtils;
    private ProgressDialog load;
    private String cpfConsulta;
    private String cnpjConsulta;
    private String numeroSolicitacaoConsulta;
    private Button butaoHistoricoEtapas;
    private Solicitacao solicitacao;
    private TextView statusSolicitacaoMeioAmbiente;
    private TextView statusSolicitacaoVigilancia;
    private Configuracoes configuracoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_solicitacao);
        DetalheSolicitacaoActivity.GetJson download = new DetalheSolicitacaoActivity.GetJson();

        razaoSocialEmpresa = findViewById(R.id.razao_social_empresa_id);
        numeroSolicitacao = findViewById(R.id.numero_solicitacao_id);
        statusSolicitacao = findViewById(R.id.status_solicitacao_id);
        cnpjEmpresaSolicitacao = findViewById(R.id.cnpj_empresa_solicitacao_id);
        recyclerView = findViewById(R.id.recycler_view_observacoes_id);
        butaoHistoricoEtapas = findViewById(R.id.butao_historico_de_etapas_id);
        statusSolicitacaoMeioAmbiente = findViewById(R.id.status_solicitacao_meio_ambiente_id);
        statusSolicitacaoVigilancia = findViewById(R.id.status_solicitacao_vigilancia_id);

        Intent intentConsulta = getIntent();
        cpfConsulta = intentConsulta.getStringExtra("cpfConsulta");
        cnpjConsulta = intentConsulta.getStringExtra("cnpjConsulta");
        numeroSolicitacaoConsulta = intentConsulta.getStringExtra("numeroSolicitacaoConsulta");
        configuracoes = (Configuracoes) intentConsulta.getSerializableExtra("configuracoes");

        butaoHistoricoEtapas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), HistoricoActivity.class);

                intent.putExtra("cpfConsulta", cpfConsulta)
                        .putExtra("cnpjConsulta", cnpjConsulta)
                        .putExtra("numeroSolicitacaoConsulta", numeroSolicitacaoConsulta)
                        .putExtra("solicitacaoUtil", carregarSolicitacaoUtils)
                        .putExtra("configuracoes", configuracoes);
                startActivity(intent);
            }
        });
        download.execute();
    }

    private class GetJson extends AsyncTask<Void, Void, Solicitacao> {

        @Override
        protected void onPreExecute() {
            load = ProgressDialog.show(DetalheSolicitacaoActivity.this, "Por favor Aguarde ...", "Recuperando Informações do Servidor...");
        }

        @Override
        protected Solicitacao doInBackground(Void... voids) {
            carregarSolicitacaoUtils = new CarregarSolicitacaoUtils();
//            solicitacao = carregarSolicitacaoUtils.getInformacao("http://10.20.30.177:8080/WebServiceRest/rest/service/solicitacao?cpf=" + cpfConsulta + "&cnpj=" + cnpjConsulta + "&numero=" + numeroSolicitacaoConsulta);
//            solicitacao = carregarSolicitacaoUtils.getInformacao("http://10.20.30.212:8080/WebServiceRest/rest/service/solicitacao?cpf=10621113387&cnpj=35148683000103&numero=1022/2017");
            solicitacao = carregarSolicitacaoUtils.getInformacao("http://10.20.30.212:8080/WebServiceRest/rest/service/solicitacao?cpf=02983125300&cnpj=41272725000205&numero=1088/2017");
            return solicitacao;
        }

        @Override
        protected void onPostExecute(Solicitacao solicitacao) {
            try {
                numeroSolicitacao.setText(numeroSolicitacaoConsulta);
                razaoSocialEmpresa.setText(solicitacao.getEmpresa());
                cnpjEmpresaSolicitacao.setText(solicitacao.getCnpj());
                statusSolicitacao.setText(solicitacao.getObservacoes().get(0).getStatus());
                statusSolicitacaoMeioAmbiente.setText(solicitacao.getObservacoesMeioAmbiente().get(0).getStatus());
                statusSolicitacaoVigilancia.setText(solicitacao.getObservacoesVigilancia().get(0).getStatus());
                load.dismiss();
            } catch (Exception e) {
//                finish();
//                Toast.makeText(getApplicationContext(), "Erro Inesperado, Tente novamente", Toast.LENGTH_LONG).show();
                statusSolicitacaoMeioAmbiente.setText("Não Disponivel");
                statusSolicitacaoVigilancia.setText("Não Disponivel");
                load.dismiss();
            }
        }
    }
}
