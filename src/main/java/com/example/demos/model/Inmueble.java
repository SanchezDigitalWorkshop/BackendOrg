package com.example.demos.model;

import com.azure.spring.data.cosmos.core.mapping.Container;
import org.springframework.data.annotation.Id;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
@Container(containerName = "Inmuebles") // Nombre del contenedor en Cosmos DB
public class Inmueble {
    @Id
    private String id;
    private String tipoPropiedad;
    private String categoria;
    private int metrosCuadrados;
    private double precio;
    private Direccion direccion;
    private int habitaciones;
    private int banos;
    private String descripcion;
    private LocalDate fechaDisponibilidad;
    private String estado;
    private String clienteId;
    private List<String> imagenes;
}