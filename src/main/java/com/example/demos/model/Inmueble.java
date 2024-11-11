package com.example.demos.model;

public class Inmueble {
    private Long id;
    private String categoria; // Ej: "Renta", "Venta"
    private String tipoPropiedad; // Ej: "Casa", "Terreno", "Mansión"
    private int metrosCuadrados;
    private double precio;
    private String direccion;
    private int habitaciones;
    private int banos;
    private String descripcion;

    // Constructor
    public Inmueble(Long id, String categoria, String tipoPropiedad, int metrosCuadrados, double precio, String direccion, int habitaciones, int banos, String descripcion) {
        this.id = id;
        this.categoria = categoria;
        this.tipoPropiedad = tipoPropiedad;
        this.metrosCuadrados = metrosCuadrados;
        this.precio = precio;
        this.direccion = direccion;
        this.habitaciones = habitaciones;
        this.banos = banos;
        this.descripcion = descripcion;
    }

    public Inmueble() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTipoPropiedad() {
        return tipoPropiedad;
    }

    public void setTipoPropiedad(String tipoPropiedad) {
        this.tipoPropiedad = tipoPropiedad;
    }

    public int getMetrosCuadrados() {
        return metrosCuadrados;
    }

    public void setMetrosCuadrados(int metrosCuadrados) {
        this.metrosCuadrados = metrosCuadrados;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(int habitaciones) {
        this.habitaciones = habitaciones;
    }

    public int getBanos() {
        return banos;
    }

    public void setBanos(int banos) {
        this.banos = banos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
