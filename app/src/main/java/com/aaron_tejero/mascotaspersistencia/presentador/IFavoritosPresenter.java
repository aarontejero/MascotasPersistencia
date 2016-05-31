package com.aaron_tejero.mascotaspersistencia.presentador;

import com.aaron_tejero.mascotaspersistencia.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by AaronTejero on 30/05/2016.
 */
public interface IFavoritosPresenter {

    void obtenerFavoritos();

    ArrayList<Mascota> getLista();

}
