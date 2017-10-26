package br.com.consultassmt.smt_consultas.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import br.com.consultassmt.smt_consultas.R;
import br.com.consultassmt.smt_consultas.adapter.TabAdapter;
import br.com.consultassmt.smt_consultas.helper.SlidingTabLayout;
import br.com.consultassmt.smt_consultas.modelo.Solicitacao;
import br.com.consultassmt.smt_consultas.utils.CarregarSolicitacaoUtils;

public class HistoricoActivity extends AppCompatActivity {

    private SlidingTabLayout slidingTabLayout;
    private ViewPager viewPager;
    private String cpfConsulta;
    private String cnpjConsulta;
    private String numeroSolicitacaoConsulta;
    private Solicitacao solicitacao;
    private CarregarSolicitacaoUtils carregarSolicitacaoUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico);

        slidingTabLayout = findViewById(R.id.stl_tabs);
        viewPager = findViewById(R.id.vp_pagina);

        Intent intentConsulta = getIntent();
        cpfConsulta = intentConsulta.getStringExtra("cpfConsulta");
        cnpjConsulta = intentConsulta.getStringExtra("cnpjConsulta");
        numeroSolicitacaoConsulta = intentConsulta.getStringExtra("numeroSolicitacaoConsulta");
        carregarSolicitacaoUtils = (CarregarSolicitacaoUtils) intentConsulta.getSerializableExtra("solicitacaoUtils");

        slidingTabLayout.setDistributeEvenly(true);
        slidingTabLayout.setSelectedIndicatorColors(ContextCompat.getColor(this, R.color.accent));
//        slidingTabLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.white));

        TabAdapter tabAdapter = new TabAdapter(getSupportFragmentManager());
        viewPager.setAdapter(tabAdapter);
        slidingTabLayout.setViewPager(viewPager);
        getSupportActionBar().setElevation(0);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.dica_observacao, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.dica_app_id:
                AlertDialog.Builder builder = new AlertDialog.Builder(HistoricoActivity.this);
                builder.setTitle("Informações");
                builder.setMessage("Ao clicar em cima de uma observação, você tera mais informações!");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                }).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
