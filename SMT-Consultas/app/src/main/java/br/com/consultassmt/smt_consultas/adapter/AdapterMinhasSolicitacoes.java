package br.com.consultassmt.smt_consultas.adapter;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import br.com.consultassmt.smt_consultas.R;
import br.com.consultassmt.smt_consultas.modelo.Observacao;

/**
 * Created by Kassio on 26/09/2017.
 */

public class AdapterMinhasSolicitacoes extends RecyclerView.Adapter<AdapterMinhasSolicitacoes.ViewHolder> {

    private final Context context;
    private List<Observacao> minhasSolicitacoes;
    private int posicao;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        protected TextView numeroSolicitacao;
        protected TextView nomeEmpresaSolicitacao;
        protected TextView solicitanteSolicitacao;
        protected TextView statusSolicitacao;
        protected TextView observacao;
        protected TextView dataCadastro;
        protected Button botaoDetalharSolicitacao;

        public ViewHolder(View itemView) {
            super(itemView);
            numeroSolicitacao = itemView.findViewById(R.id.numero_solicitacao_id);
            nomeEmpresaSolicitacao = itemView.findViewById(R.id.empresa_id);
            solicitanteSolicitacao = itemView.findViewById(R.id.solicitante_solicitacao_id);
            statusSolicitacao = itemView.findViewById(R.id.status_solicitacao_id);
            observacao = itemView.findViewById(R.id.observacao_id);
            dataCadastro = itemView.findViewById(R.id.data_cadastro_id);
            botaoDetalharSolicitacao = itemView.findViewById(R.id.botao_detalhar_solicitacao_id);
        }
    }

    public AdapterMinhasSolicitacoes(Context context, List<Observacao> minhasSolicitacoes) {
        this.context = context;
//        this.minhasSolicitacoes = CarregarSolicitacaoUtils.getSolicitacao().getObservacoes();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflator = LayoutInflater.from(parent.getContext());
        View view = inflator.inflate(R.layout.item_minhas_solicitacoes, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final AdapterMinhasSolicitacoes.ViewHolder holder, final int position) {
//        final List<Observacao> solicitacoes = CarregarSolicitacaoUtils.getSolicitacao().getObservacoes();

//        holder.numeroSolicitacao.setText(CarregarSolicitacaoUtils.getObservacoes().get(position).getNumeroSolicitacao());
//        holder.nomeEmpresaSolicitacao.setText(CarregarSolicitacaoUtils.getObservacoes().get(position).getEmpresa());
//        holder.solicitanteSolicitacao.setText(CarregarSolicitacaoUtils.getObservacoes().get(position).getSolicitante());
//        holder.statusSolicitacao.setText(CarregarSolicitacaoUtils.getSolicitacao().getObservacoes().get(position).getStatus());
//        holder.observacao.setText(CarregarSolicitacaoUtils.getSolicitacao().getObservacoes().get(position).getStatus());
//        holder.dataCadastro.setText(CarregarSolicitacaoUtils.getObservacoes().get(position).getDataCadastro());

        holder.botaoDetalharSolicitacao.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Apertou", Snackbar.LENGTH_SHORT).show();
                posicao = position;
            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
//        return CarregarSolicitacaoUtils.getSolicitacao().getObservacoes().size();
    }

    public int getPosicao() {
        return posicao;
    }
}
