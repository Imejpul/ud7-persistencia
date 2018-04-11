package com.imejpul;

public class Etapa {

    private int id;
    private String tipo;
    private String titulo;
    private String descripcion;
    private int id_viaje;

    private Viaje viaje;

    public Etapa() {
    }

    public Etapa(int id, String tipo, String titulo, String descripcion, int id_viaje) {
        this.id = id;
        this.tipo = tipo;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.id_viaje = id_viaje;
    }

    public Etapa(String tipo, String titulo, String descripcion) {
        this.id = -1;
        this.tipo = tipo;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.id_viaje = -1;
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
