package com.example.demos.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "inmuebles")
public class Inmueble {
    @Id
    private String id;
    private String tipoOperacion; // Venta o Alquiler
    private String tipoPropiedad; // Casa, Departamento, etc.
    private String tipoProyecto; // En plano, En construcción,  
    private Ubicacion ubicacion;
    private Caracteristicas caracteristicas;
    private Precio precio;
    private Descripcion descripcion;
    private Multimedia multimedia;
    private AspectosAdicionales aspectosAdicionales;
    private String estado; // Disponible o no
    private LocalDate fechaDisponibilidad;
    private String clienteId;
    private String partition;
    private LocalDateTime fechaCreacion = LocalDateTime.now();
    private int prioridad;
    private boolean activo;
    private boolean descatado;
}