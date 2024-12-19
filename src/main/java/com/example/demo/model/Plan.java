package com.example.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "planes")
public class Plan {
    @Id
    private String id;
    private String nombrePlan; // Nombre del plan (Ejemplo: "Plan Premium")
    private String descripcion; // Descripción breve del plan
    private double monto; // Monto del plan
    private List<MetodoPago> metodosPago; // Lista de métodos de pago
    private String estado; // Activo o Inactivo
    private LocalDateTime fechaCreacion; // Fecha de creación del plan
    private LocalDateTime fechaActualizacion; // Última fecha de actualización
}
