package com.aaron_tejero.mascotaspersistencia.Adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aaron_tejero.mascotaspersistencia.R;
import com.aaron_tejero.mascotaspersistencia.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by AaronTejero on 30/05/2016.
 */
public class FavoritosAdapter extends RecyclerView.Adapter<FavoritosAdapter.MascotaViewHolder> {


    ArrayList<Mascota> mascotas;
    Activity activity;


    public class MascotaViewHolder extends RecyclerView.ViewHolder{
        private TextView nombre;
        private TextView raiting;
        private ImageView foto;
        private ImageView hueso;
        public MascotaViewHolder(View v) {
            super(v);
            foto=(ImageView) v.findViewById(R.id.imgFoto);
           // nombre=(TextView) v.findViewById(R.id.tvNombrePerro);
            raiting=(TextView) v.findViewById(R.id.tvraiting);
           // hueso=(ImageView) v.findViewById(R.id.imgHuesoblanco);
        }
    }

    public FavoritosAdapter(ArrayList<Mascota> items,Activity activity){
        this.mascotas=items;
        this.activity=activity;

    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_mascotas,viewGroup,false);
        return new MascotaViewHolder(v);

    }

    @Override
    public void onBindViewHolder(MascotaViewHolder viewHolder, int i) {
        //viewHolder.foto.setImageResource(mascotas.get(i).getFoto());
        viewHolder.nombre.setText(mascotas.get(i).getNombreCompleto());
        viewHolder.raiting.setText(String.valueOf(mascotas.get(i).getRaiting()));
        viewHolder.hueso.setTag(viewHolder);

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }
}


