package br.com.consultassmt.smt_consultas.adapter;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.com.consultassmt.smt_consultas.R;
import br.com.consultassmt.smt_consultas.modelo.Observacao;

/**
 * Created by Kassio on 02/10/2017.
 */

public class AdapterObservacoes extends RecyclerView.Adapter<AdapterObservacoes.ViewHolder> {

    private final Context context;
    private final List<Observacao> observacoes;

    public AdapterObservacoes(Context context, List<Observacao> observacoes) {
        this.context = context;
        this.observacoes = observacoes;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView observacao;
        protected TextView status;
        protected TextView orgao;
        protected TextView textoObservacao;
        protected TextView horario;

        public ViewHolder(View itemView) {
            super(itemView);
            observacao = itemView.findViewById(R.id.obervacao_id);
            textoObservacao = itemView.findViewById(R.id.texto_observacao_id);
            horario = itemView.findViewById(R.id.horario_id);
        }

    }

    @Override
    public AdapterObservacoes.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_observacao_solicitacao, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final AdapterObservacoes.ViewHolder holder, final int position) {

        if(observacoes.get(position).getObservacao().equals("") || observacoes.get(position).getObservacao().equals(" ")){
            holder.observacao.setText("Aguardando Analise");
        } else {
            holder.observacao.setText(observacoes.get(position).getObservacao().toLowerCase());
        }

        holder.horario.setText(""+observacoes.get(position).getDataHora());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Usuario: " + observacoes.get(position).getUsuario()+"\nStatus: " + observacoes.get(position).getStatus(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return observacoes.size();
    }
}
