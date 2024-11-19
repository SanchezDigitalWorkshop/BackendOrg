package com.example.demos.model;

import lombok.Data;

import java.util.List;

@Data
public class Multimedia {
    private List<String> imagenes; // URLs de imágenes
    private List<String> videos; // URLs de videos (YouTube)
}