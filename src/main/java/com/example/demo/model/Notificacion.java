package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "notificaciones")
public class Notificacion {
    @Id
    private String id;
    private long numeroNotificaciones;
}
