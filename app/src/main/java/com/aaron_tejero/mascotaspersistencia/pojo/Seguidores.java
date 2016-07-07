package com.aaron_tejero.mascotaspersistencia.pojo;

/**
 * Created by AaronTejero on 04/07/2016.
 */
public class Seguidores {

    private String id;
    private String nombre;
    private String usuario;
    private String fotoPerfil;

    public Seguidores(String nombre, String usuario, String fotoPerfil) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.fotoPerfil = fotoPerfil;
    }

    public Seguidores(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }
}
