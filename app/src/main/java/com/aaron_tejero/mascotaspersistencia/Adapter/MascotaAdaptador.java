package com.aaron_tejero.mascotaspersistencia.Adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import com.aaron_tejero.mascotaspersistencia.db.ConstructorMascotas;
import com.aaron_tejero.mascotaspersistencia.pojo.Mascota;
import com.aaron_tejero.mascotaspersistencia.R;
import com.squareup.picasso.Picasso;

/**
 * Created by AaronTejero on 15/05/2016.
 */
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    //private List<Mascota> items;
    ArrayList<Mascota> mascotas;
    Activity activity;

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{


        private TextView raiting;
        private TextView nombreCompleto;
        private ImageView foto;
        private ImageView hueso;
            public MascotaViewHolder(View v){
                super (v);
                foto=(ImageView) v.findViewById(R.id.imgFoto);

                raiting=(TextView) v.findViewById(R.id.tvraiting);
                nombreCompleto=(TextView) v.findViewById(R.id.tvnombrecompleto);

            }
        }

    public MascotaAdaptador(ArrayList<Mascota> items,Activity activity){
        this.mascotas=items;
        this.activity=activity;

    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_mascotas,viewGroup,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder viewHolder,final int i) {
        //viewHolder.foto.setImageResource(mascotas.get(i).getFoto());

        Picasso.with(activity)
                .load(mascotas.get(i).getUrlFoto())
                .placeholder(R.drawable.perro1)
                .into(viewHolder.foto);

        viewHolder.raiting.setText(String.valueOf(mascotas.get(i).getRaiting()));
        viewHolder.nombreCompleto.setText(String.valueOf(mascotas.get(i).getNombreCompleto()));
        //viewHolder.hueso.setTag(viewHolder);

    }


    @Override
    public int getItemCount() {
        return mascotas.size();
    }
}
