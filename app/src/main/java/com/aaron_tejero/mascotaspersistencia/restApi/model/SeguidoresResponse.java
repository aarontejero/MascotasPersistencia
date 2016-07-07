package com.aaron_tejero.mascotaspersistencia.restApi.model;

import com.aaron_tejero.mascotaspersistencia.pojo.Mascota;
import com.aaron_tejero.mascotaspersistencia.pojo.Seguidores;

import java.util.ArrayList;

/**
 * Created by AaronTejero on 04/07/2016.
 */
public class SeguidoresResponse {
    ArrayList<Seguidores> seguidores;

    public ArrayList<Seguidores> getSeguidores() {
        return seguidores;
    }

    public void setSeguidores(ArrayList<Seguidores> seguidores) {
        this.seguidores = seguidores;
    }
}
