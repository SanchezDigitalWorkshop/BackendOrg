package com.example.demos.model;


public class Descripcion {
    private String titulo;
    private String detalle; // Mínimo 150 caracteres

    public Descripcion() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
}