package com.example.demos.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import lombok.Data;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@Document(collection = "inmuebles")
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
    // Clave de partición
    private String partition;
    private Date fechaCreacion = new Date();
    private String prioridad;
}