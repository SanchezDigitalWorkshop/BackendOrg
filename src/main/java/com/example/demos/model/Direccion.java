package com.example.demos.model;

import lombok.Data;

@Data
public class Direccion {

    private String calle;
    private String numero;
    private String ciudad;
    private String estado;
    private String codigoPostal;
}
