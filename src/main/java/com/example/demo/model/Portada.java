package com.example.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "portada")
public class Portada {
    @Id
    private String id;
    private String imagenes;

    private String partition;
    private String partitionKey;

    // Información adicional sobre ofertas o anuncios
    private String mensajePromocional;
    private String urlPromocional; // Enlace a una página de promoción o detalle

}