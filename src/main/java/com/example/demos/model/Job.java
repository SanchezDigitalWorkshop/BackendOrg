package com.example.demos.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "jobs")
public class Job {
    @Id
    private String id;
    private String nombreEmpleo;
    private String fotoEmpleo; // URL de la imagen
    private String lugar;
    private String telefono;
    private String tiempo; // Tiempo de empleo (por ejemplo: "Full-time" o "Part-time")
    private int vacantes;
    private double pago; // Salario en números
}