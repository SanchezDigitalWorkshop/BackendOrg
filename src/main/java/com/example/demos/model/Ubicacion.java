package com.example.demos.model;

import lombok.Data;

@Data
public class Ubicacion {
    private String calleNumero;
    private String direccionCompleta;
    private String departamento;
    private String provincia;
    private String formaUbicacion; // Exacta o Aproximada
    private String logitud;
    private String latitud;
}