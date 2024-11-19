package com.example.demos.model;

import lombok.Data;

public class Precio {
    private Double pen; // Permite nulo
    private Double usd; // Permite nulo

    public Precio() {
    }

    public Double getPen() {
        return pen;
    }

    public void setPen(Double pen) {
        this.pen = pen;
    }

    public Double getUsd() {
        return usd;
    }

    public void setUsd(Double usd) {
        this.usd = usd;
    }
}