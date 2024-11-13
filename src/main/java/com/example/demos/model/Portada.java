package com.example.demos.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@Document(collection = "portada")
public class Portada {
    @Id
    private String id;
    private String imagenes;
    private String partition;
}