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

import br.com.consultassmt.smt_consultas.R;
import br.com.consultassmt.smt_consultas.adapter.AdapterObservacoes;
import br.com.consultassmt.smt_consultas.modelo.Observacao;
import br.com.consultassmt.smt_consultas.utils.CarregarSolicitacaoUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public class VigilanciaFragment extends Fragment {

    private TextView statusVigilancia;
    private List<Observacao> listaObservacoesVigilancia;
    private RecyclerView recyclerViewObservacoesVigilancia;


    public VigilanciaFragment() {
        // Required empty public constructor
        listaObservacoesVigilancia = CarregarSolicitacaoUtils.getSolicitacao().getObservacoesVigilancia();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vigilancia, container, false);

        statusVigilancia = view.findViewById(R.id.status_vigilancia_id);
        recyclerViewObservacoesVigilancia = view.findViewById(R.id.recycler_view_observacoes_vigilancia_id);

        try {
            statusVigilancia.setText(listaObservacoesVigilancia.get(0).getStatus());
        } catch (NullPointerException e) {
            statusVigilancia.setText("Não Disponivel");
        } catch (IndexOutOfBoundsException e) {
            statusVigilancia.setText("Não Disponivel");
        }

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        try {
            AdapterObservacoes adapterObservacoes = new AdapterObservacoes(getContext(), inverterLista(listaObservacoesVigilancia));
            recyclerViewObservacoesVigilancia.setAdapter(adapterObservacoes);
            recyclerViewObservacoesVigilancia.setLayoutManager(new LinearLayoutManager(getContext()));
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
