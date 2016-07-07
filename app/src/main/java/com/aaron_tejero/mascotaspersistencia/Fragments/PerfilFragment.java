package com.aaron_tejero.mascotaspersistencia.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import com.aaron_tejero.mascotaspersistencia.Adapter.MascotaPerfilAdaptador;
import com.aaron_tejero.mascotaspersistencia.pojo.Mascota;
import com.aaron_tejero.mascotaspersistencia.R;
import com.aaron_tejero.mascotaspersistencia.pojo.Seguidores;
import com.aaron_tejero.mascotaspersistencia.presentador.IPerfilFragmentPresenter;
import com.aaron_tejero.mascotaspersistencia.presentador.PerfilFragmentPresenter;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;

/**
 * Created by AaronTejero on 22/05/2016.
 */
public class PerfilFragment extends Fragment implements IperfilFragment {

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private GridLayoutManager glm;
    ArrayList<Mascota> mascotas;
    private RecyclerView.LayoutManager lManager;

    private IPerfilFragmentPresenter presentador;
    private CircularImageView circularImageView;
    private TextView tvNombrePerfil;




    public PerfilFragment() {
        // Required empty public constructor
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_perfil, container, false);
        circularImageView = (CircularImageView)v.findViewById(R.id.imagenPerfil);
        tvNombrePerfil = (TextView)v.findViewById(R.id.nombreperfil);
        //mascotas=new ArrayList<Mascota>();
        recycler=(RecyclerView) v.findViewById(R.id.rvfotosperfil);
        recycler.setHasFixedSize(true);
        /*glm= new GridLayoutManager(getActivity(),2, GridLayoutManager.VERTICAL,false);
        recycler.setLayoutManager(glm);
        adapter=new MascotaPerfilAdaptador(mascotas,getActivity());
        recycler.setAdapter(adapter);*/
        presentador = new PerfilFragmentPresenter(this, getContext(), obtieneCuentaInstagram());
        return v;

    }

    private String obtieneCuentaInstagram() {
        SharedPreferences misReferencias =  this.getActivity().getSharedPreferences("shared", Context.MODE_PRIVATE);
        return misReferencias.getString("perfilInstagram", "");
    }

    @Override
    public void generarGridLayout() {
        lManager = new GridLayoutManager(getActivity(), 2);
        recycler.setLayoutManager(lManager);
    }

    @Override
    public MascotaPerfilAdaptador crearAdaptadorPerfil(ArrayList<Mascota> mascotas) {
        MascotaPerfilAdaptador adaptador = new MascotaPerfilAdaptador(mascotas, getActivity());
        return adaptador;

    }

    @Override
    public void inicializaAdaptadorPerfil(MascotaPerfilAdaptador adapter) {
        recycler.setHasFixedSize(true);
        recycler.setAdapter(adapter);
    }

    @Override
    public void creaImagenPerfil(Seguidores perfilUsuario) {
        Picasso.with(getActivity())
                .load(perfilUsuario.getFotoPerfil())
                .placeholder(R.drawable.perro1)
                .into(circularImageView);

        tvNombrePerfil.setText(perfilUsuario.getNombre());
    }
}
