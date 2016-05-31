package com.aaron_tejero.mascotaspersistencia.pojo;

/**
 * Created by AaronTejero on 15/05/2016.
 */
public class Mascota {


    int id;
    int foto;
    String nombre;
    int raiting;
    private boolean like;

    public Mascota(int foto, String nombre, int raiting){
        this.foto=foto;
        this.nombre=nombre;
        this.raiting=raiting;
        this.like=false;

    }
    public Mascota() {

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getRaiting() {
        return raiting;
    }

    public void setRaiting(int raiting) {
        this.raiting = raiting;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }
}
