package com.imejpul;

import java.util.ArrayList;
import java.util.List;

public class Viaje {

    private int id;
    private String titulo;
    private List<Etapa> etapas = new ArrayList<>();

    public Viaje(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public Viaje(String titulo) {
        this.id = -1;
        this.titulo = titulo;
    }

    public Viaje() {
    }

    @Override
    public String toString() {
        return "Viaje{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", etapas=" + etapas +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Etapa> getEtapas() {
        return etapas;
    }
}
