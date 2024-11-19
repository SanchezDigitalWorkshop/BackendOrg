package com.example.demos.model;

import lombok.Data;

@Data
public class Caracteristicas {
    private int dormitorios;
    private int banos;
    private int medioBanos;
    private int estacionamientos;
    private double areaConstruida;
    private double areaTotal;
    private String antiguedad; // A estrenar, Años de antigüedad, En construcción
}
