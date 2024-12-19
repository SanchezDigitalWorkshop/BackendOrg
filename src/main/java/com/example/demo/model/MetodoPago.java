package com.example.demo.model;

import lombok.Data;

@Data
public class MetodoPago {
    private String tipo; // Tipo de método (Plin, Yape, etc.)
    private String detalle; // Detalle del método (ej: número de cuenta)
    private String qr; // URL del código QR
}