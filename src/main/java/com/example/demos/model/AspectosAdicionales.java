package com.example.demos.model;

import lombok.Data;

import java.util.List;

@Data
public class AspectosAdicionales {
    private List<String> caracteristicasGenerales;
    private List<String> exteriores;
    private List<String> servicios;
    private List<String> areasComunes;
}