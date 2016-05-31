package com.aaron_tejero.mascotaspersistencia.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import com.aaron_tejero.mascotaspersistencia.Adapter.MascotaAdaptador;
import com.aaron_tejero.mascotaspersistencia.pojo.Mascota;
import com.aaron_tejero.mascotaspersistencia.R;
import com.aaron_tejero.mascotaspersistencia.presentador.IRecyclerViewFragmentPresenter;
import com.aaron_tejero.mascotaspersistencia.presentador.RecyclerViewFragmentPresenter;

/**
 * Created by AaronTejero on 22/05/2016.
 */
public class RecyclerViewFragment extends Fragment implements IRecyclerviewFragment {

    private RecyclerView recycler;
    ArrayList<Mascota> mascotas;
    private IRecyclerViewFragmentPresenter presenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_recyclerview,container, false);

        recycler=(RecyclerView) v.findViewById(R.id.reciclador);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());
        //recycler.setHasFixedSize(true);
        return v;
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager lManager=new LinearLayoutManager(getActivity());
        lManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(lManager);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador  adapter=new MascotaAdaptador(mascotas,getActivity());
        return adapter;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        recycler.setAdapter(adaptador);
    }
}
