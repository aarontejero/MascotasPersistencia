package com.aaron_tejero.mascotaspersistencia.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import com.aaron_tejero.mascotaspersistencia.Adapter.MascotaPerfilAdaptador;
import com.aaron_tejero.mascotaspersistencia.pojo.Mascota;
import com.aaron_tejero.mascotaspersistencia.R;

/**
 * Created by AaronTejero on 22/05/2016.
 */
public class PerfilFragment extends Fragment {

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private GridLayoutManager glm;
    ArrayList<Mascota> mascotas;
    public PerfilFragment() {
        // Required empty public constructor
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_perfil, container, false);

        mascotas=new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.perro1,"", 8));
        mascotas.add(new Mascota(R.drawable.perro1,"", 7));
        mascotas.add(new Mascota(R.drawable.perro1, "", 5));
        mascotas.add(new Mascota(R.drawable.perro1, "", 4));
        mascotas.add(new Mascota(R.drawable.perro1, "", 3));
        mascotas.add(new Mascota(R.drawable.perro1, "", 2));

        recycler=(RecyclerView) v.findViewById(R.id.rvfotosperfil);
        recycler.setHasFixedSize(true);

        glm= new GridLayoutManager(getActivity(),2, GridLayoutManager.VERTICAL,false);
        recycler.setLayoutManager(glm);
        adapter=new MascotaPerfilAdaptador(mascotas,getActivity());
        recycler.setAdapter(adapter);


        return v;
    }
}
