package com.aaron_tejero.mascotaspersistencia.presentador;

import android.content.Context;

import com.aaron_tejero.mascotaspersistencia.Fragments.IRecyclerviewFragment;
import com.aaron_tejero.mascotaspersistencia.db.ConstructorMascotas;
import com.aaron_tejero.mascotaspersistencia.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by AaronTejero on 30/05/2016.
 */
public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    IRecyclerviewFragment iRecyclerviewFragment;
    Context context;
    private ConstructorMascotas constructorMascotas;
    ArrayList<Mascota> mascotas;

    public RecyclerViewFragmentPresenter(IRecyclerviewFragment iRecyclerviewFragment,Context context) {
        this.iRecyclerviewFragment=iRecyclerviewFragment;
        this.context=context;
        obtenerMascotasBD();
    }

    @Override
    public void obtenerMascotasBD() {

        constructorMascotas=new ConstructorMascotas(context);
        mascotas=constructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iRecyclerviewFragment.inicializarAdaptadorRV(iRecyclerviewFragment.crearAdaptador(mascotas));
        iRecyclerviewFragment.generarLinearLayoutVertical();
    }
}
