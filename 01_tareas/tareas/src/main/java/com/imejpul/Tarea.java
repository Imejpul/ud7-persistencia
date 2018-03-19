package com.imejpul;

import java.util.Objects;

public class Tarea {

    private boolean estado;
    private String texto;

    public Tarea(boolean estado, String texto) {
        this.estado = estado;
        this.texto = texto;
    }

    public Tarea() {
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "estado=" + estado +
                ", texto='" + texto + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tarea tarea = (Tarea) o;
        return Objects.equals(texto, tarea.texto);
    }

    @Override
    public int hashCode() {

        return Objects.hash(texto);
    }
}
