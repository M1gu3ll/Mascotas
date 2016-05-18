package com.mvalverde.mascotas;

/**
 * Created by mvalverde on 17/05/2016.
 */
public class Mascota {

    private int foto;
    private String nombre;
    private int like;

    public Mascota(int foto, String nombre, int like) {
        this.foto = foto;
        this.nombre = nombre;
        this.like = like;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
