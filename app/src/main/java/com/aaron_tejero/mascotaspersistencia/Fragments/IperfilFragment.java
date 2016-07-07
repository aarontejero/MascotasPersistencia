package com.aaron_tejero.mascotaspersistencia.Fragments;

import com.aaron_tejero.mascotaspersistencia.Adapter.MascotaPerfilAdaptador;
import com.aaron_tejero.mascotaspersistencia.pojo.Mascota;
import com.aaron_tejero.mascotaspersistencia.pojo.Seguidores;

import java.util.ArrayList;

/**
 * Created by AaronTejero on 06/07/2016.
 */
public interface IperfilFragment {

        public void generarGridLayout();
        public MascotaPerfilAdaptador crearAdaptadorPerfil(ArrayList<Mascota> mascotas);
        public void inicializaAdaptadorPerfil(MascotaPerfilAdaptador adapter);
        public void creaImagenPerfil(Seguidores perfilUsuario);
    }


