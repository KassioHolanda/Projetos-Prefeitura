package br.com.consultassmt.smt_consultas.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import br.com.consultassmt.smt_consultas.fragment.MeioAmbienteFragment;
import br.com.consultassmt.smt_consultas.fragment.SduFragment;
import br.com.consultassmt.smt_consultas.fragment.VigilanciaFragment;
import br.com.consultassmt.smt_consultas.utils.CarregarSolicitacaoUtils;

/**
 * Created by Kassio on 10/10/2017.
 */

public class TabAdapter extends FragmentStatePagerAdapter {

    private String[] tituloAba = {"SDU", "M. Ambiente", "V. Sanitaria"};
    private CarregarSolicitacaoUtils carregarSolicitacaoUtils;

    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = new SduFragment();
                break;
            case 1:
                fragment = new MeioAmbienteFragment();
                break;
            case 2:
                fragment = new VigilanciaFragment();
                break;
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return tituloAba.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tituloAba[position];
    }

    public String[] getTituloAba() {
        return tituloAba;
    }

}
