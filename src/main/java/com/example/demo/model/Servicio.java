package com.example.demo.model;

import lombok.Data;

@Data
public class Servicio {
    private boolean agua = false;
    private boolean electricidad = false;
    private boolean gasNatural = false;
    private boolean internet = false;
    private boolean telefono = false;
    private boolean televisionCable = false;
    private boolean aireAcondicionado = false;
    private boolean calefaccion = false;
    private boolean ascensor = false;
    private boolean piscina = false;
    private boolean gimnasio = false;
    private boolean seguridad24Horas = false;
    private boolean estacionamiento = false;
    private boolean accesoDiscapacidad = false;

    /**
     * Método para completar valores predeterminados si algún campo es nulo o no está asignado.
     */
    public void completarDatosPorDefecto() {
        this.agua = this.agua;
        this.electricidad = this.electricidad;
        this.gasNatural = this.gasNatural;
        this.internet = this.internet;
        this.telefono = this.telefono;
        this.televisionCable = this.televisionCable;
        this.aireAcondicionado = this.aireAcondicionado;
        this.calefaccion = this.calefaccion;
        this.ascensor = this.ascensor;
        this.piscina = this.piscina;
        this.gimnasio = this.gimnasio;
        this.seguridad24Horas = this.seguridad24Horas;
        this.estacionamiento = this.estacionamiento;
        this.accesoDiscapacidad = this.accesoDiscapacidad;
    }
}
