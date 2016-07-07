package com.aaron_tejero.mascotaspersistencia.restApi.model;

import com.aaron_tejero.mascotaspersistencia.pojo.Seguidores;

/**
 * Created by AaronTejero on 06/07/2016.
 */
public class BusquedaResponse {
    Seguidores cuenta;
    public Seguidores getCuenta() {
        return cuenta;
    }

    public void setCuenta(Seguidores cuenta) {
        this.cuenta = cuenta;
    }
}
