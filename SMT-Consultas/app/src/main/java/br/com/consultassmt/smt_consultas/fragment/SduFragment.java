package br.com.consultassmt.smt_consultas.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import br.com.consultassmt.smt_consultas.R;
import br.com.consultassmt.smt_consultas.adapter.AdapterObservacoes;
import br.com.consultassmt.smt_consultas.modelo.Observacao;
import br.com.consultassmt.smt_consultas.utils.CarregarSolicitacaoUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public class SduFragment extends Fragment {

    private List<Observacao> listaObservacaoAcessibilidade;
    private List<Observacao> listaObservacaoConsultaPrevia;
    private RecyclerView recyclerViewObservacaoAcessibilidade;
    private RecyclerView recyclerViewobservacoesConsultaPrevia;
    private TextView statusConsultaPrevia;
    private TextView statusAcessibilidade;


    public SduFragment() {
        // Required empty public constructor
        listaObservacaoAcessibilidade = CarregarSolicitacaoUtils.getSolicitacao().getObservacoesSduAcessibilidade();
        listaObservacaoConsultaPrevia = CarregarSolicitacaoUtils.getSolicitacao().getObservacoesSduConsultaPrevia();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sdu, container, false);

        recyclerViewObservacaoAcessibilidade = view.findViewById(R.id.recycler_view_observacao_acessibilidade_id);
        recyclerViewobservacoesConsultaPrevia = view.findViewById(R.id.recycler_view_observacoes_consulta_previa_id);
        statusConsultaPrevia = view.findViewById(R.id.status_consulta_previa_id);
        statusAcessibilidade = view.findViewById(R.id.status_acessibilidade_id);

        try {
            statusConsultaPrevia.setText(listaObservacaoConsultaPrevia.get(0).getStatus());
        } catch (NullPointerException e){
            statusConsultaPrevia.setText("Não Disponivel");
        } catch (IndexOutOfBoundsException e){
            statusConsultaPrevia.setText("Não Disponivel");
        }

        try {
            statusAcessibilidade.setText(listaObservacaoAcessibilidade.get(0).getStatus());
        } catch (NullPointerException e){
            statusAcessibilidade.setText("Não Disponivel");
        } catch (IndexOutOfBoundsException e){
            statusAcessibilidade.setText("Não Disponivel");
        }

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        try {
            AdapterObservacoes adapterObservacoes = new AdapterObservacoes(getContext(), inverterLista(listaObservacaoConsultaPrevia));
            recyclerViewobservacoesConsultaPrevia.setAdapter(adapterObservacoes);
            recyclerViewobservacoesConsultaPrevia.setLayoutManager(new LinearLayoutManager(getContext()));
        } catch (NullPointerException e) {
            Toast.makeText(getContext(), "Ocorreu um erro, tente novamente", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
            onStop();
        }

        try {
            AdapterObservacoes adapterObservacoes = new AdapterObservacoes(getContext(), inverterLista(listaObservacaoAcessibilidade));
            recyclerViewObservacaoAcessibilidade.setAdapter(adapterObservacoes);
            recyclerViewObservacaoAcessibilidade.setLayoutManager(new LinearLayoutManager(getContext()));
        } catch (NullPointerException e) {
            Toast.makeText(getContext(), "Ocorreu um erro, tente novamente", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
//            onStop();
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
