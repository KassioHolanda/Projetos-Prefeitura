package br.com.consultassmt.smt_consultas.fragment;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AlertDialogLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.consultassmt.smt_consultas.R;
import br.com.consultassmt.smt_consultas.activities.HistoricoActivity;
import br.com.consultassmt.smt_consultas.adapter.AdapterObservacoes;
import br.com.consultassmt.smt_consultas.modelo.Observacao;
import br.com.consultassmt.smt_consultas.modelo.Solicitacao;
import br.com.consultassmt.smt_consultas.utils.CarregarSolicitacaoUtils;

/**
 * A simple {@link Fragment} subclass.
 */

public class MeioAmbienteFragment extends Fragment {

    private TextView status;
    private RecyclerView recyclerViewObservacoesMeioAmbiente;
    private List<Observacao> listasSolicitacaoMeioAmbiente;
    private String[] dados;

    public MeioAmbienteFragment() {
        // Required empty public constructor
        listasSolicitacaoMeioAmbiente = CarregarSolicitacaoUtils.getSolicitacao().getObservacoesMeioAmbiente();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_meio_ambiente, container, false);

        status = view.findViewById(R.id.status_id);
        recyclerViewObservacoesMeioAmbiente = view.findViewById(R.id.recycler_view_observacoes_meio_ambiente_id);

        try {
            status.setText(listasSolicitacaoMeioAmbiente.get(0).getStatus());
        } catch (NullPointerException e){
            status.setText("Não Disponivel");
        } catch (IndexOutOfBoundsException e){
            status.setText("Não Disponivel");
        }
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        try {
            AdapterObservacoes adapterObservacoes = new AdapterObservacoes(getContext(), inverterLista(listasSolicitacaoMeioAmbiente));
            recyclerViewObservacoesMeioAmbiente.setAdapter(adapterObservacoes);
            recyclerViewObservacoesMeioAmbiente.setLayoutManager(new LinearLayoutManager(getContext()));
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
