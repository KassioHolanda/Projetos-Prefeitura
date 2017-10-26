package br.com.consultassmt.smt_consultas.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.orm.SugarRecord;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import br.com.consultassmt.smt_consultas.R;
import br.com.consultassmt.smt_consultas.modelo.Configuracoes;

public class PaginaIncialActivity extends AppCompatActivity {

    private Button consular;
    private EditText cpfConsulta;
    private EditText cnpjConsulta;
    private EditText numeroSolicitacaoConsulta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_incial);

        consular = findViewById(R.id.button_consulta_id);
        cpfConsulta = findViewById(R.id.cpf_consulta_id);
        cnpjConsulta = findViewById(R.id.cnpj_consulta_id);
        numeroSolicitacaoConsulta = findViewById(R.id.numero_solicitacao_consulta_id);

        AlertDialog.Builder builder = new AlertDialog.Builder(PaginaIncialActivity.this);
        builder.setTitle("Funcionalidades do App");
        builder.setMessage("O SMT Consultas no momento so permite ao usuario realizar consultas em solicitações cadastradas previamente!");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).show();


        consular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(), ""+ Calendar.getInstance().getTime(), Toast.LENGTH_LONG).show();
                if (cpfConsulta.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "CPF é OBRIGATORIO", Toast.LENGTH_SHORT).show();
//                } else if (cpfConsulta.getText().toString().length() != 11) {
//                    Toast.makeText(getApplicationContext(), "CPF incompleto ou invalido", Toast.LENGTH_SHORT).show();
//                } else if (cpfConsulta.getText().toString().isEmpty()) {
//                    Toast.makeText(getApplicationContext(), "CNPJ é OBRIGATORIO", Toast.LENGTH_SHORT).show();
//                } else if (cnpjConsulta.getText().toString().length() != 14) {
//                    Toast.makeText(getApplicationContext(), "CNPJ incompleto ou invalido", Toast.LENGTH_SHORT).show();
//                } else if (numeroSolicitacaoConsulta.toString().isEmpty()) {
//                    Toast.makeText(getApplicationContext(), "Numero Solicitação OBRIGATORIO", Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(new Intent(getApplicationContext(), DetalheSolicitacaoActivity.class)
                            .putExtra("cpfConsulta", cpfConsulta.getText().toString().replace(" ", ""))
                            .putExtra("cnpjConsulta", cnpjConsulta.getText().toString().replace(" ", ""))
                            .putExtra("numeroSolicitacaoConsulta", numeroSolicitacaoConsulta.getText().toString().replace(" ", "")));
                }
            }
        });
    }
}
