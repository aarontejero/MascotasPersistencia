package com.aaron_tejero.mascotaspersistencia.pojo;

/**
 * Created by AaronTejero on 15/05/2016.
 */
public class Mascota {


    String id;
    String nombreCompleto;
    String urlFoto;
    int raiting;

    private boolean like;

    public Mascota(String urlFoto, String nombreCompleto, int raiting) {
        this.urlFoto = urlFoto;
        this.nombreCompleto = nombreCompleto;
        this.raiting = raiting;
        this.like = false;

    }

    public Mascota() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public int getRaiting() {
        return raiting;
    }

    public void setRaiting(int raiting) {
        this.raiting = raiting;
    }

    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }
}
