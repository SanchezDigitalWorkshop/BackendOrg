package com.example.demo.model;

import lombok.Data;

@Data
public class Alrededores {
    private boolean cercaParques = false;
    private boolean cercaColegios = false;
    private boolean cercaHospitales = false;
    private boolean cercaCentrosComerciales = false;
    private boolean cercaSupermercados = false;
    private boolean cercaTransportePublico = false;
    private boolean zonaSegura = false;
    private boolean zonaTranquila = false;
    private boolean areaComercial = false;
    private boolean areaResidencial = false;
    private boolean vistaAlMar = false;
    private boolean vistaALaCiudad = false;

    /**
     * Método para completar los valores por defecto si algún campo está nulo.
     */
    public void completarDatosPorDefecto() {
        this.cercaParques = this.cercaParques;
        this.cercaColegios = this.cercaColegios;
        this.cercaHospitales = this.cercaHospitales;
        this.cercaCentrosComerciales = this.cercaCentrosComerciales;
        this.cercaSupermercados = this.cercaSupermercados;
        this.cercaTransportePublico = this.cercaTransportePublico;
        this.zonaSegura = this.zonaSegura;
        this.zonaTranquila = this.zonaTranquila;
        this.areaComercial = this.areaComercial;
        this.areaResidencial = this.areaResidencial;
        this.vistaAlMar = this.vistaAlMar;
        this.vistaALaCiudad = this.vistaALaCiudad;
    }
}
