package com.example.demo.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Document(collection = "inmuebles")
public class Inmueble {
    @Id
    private String id;
    private String tipoOperacion; // Venta o Alquiler
    private String tipoPropiedad; // Casa, Departamento, etc.
    private String tipoProyecto; // En plano, En const
    private Ubicacion ubicacion;
    private Caracteristicas caracteristicas;
    private Precio precio;
    private Descripcion descripcion;
    private Multimedia multimedia;
    private AspectosAdicionales aspectosAdicionales;
    private String estado; // Disponible o no
    private LocalDate fechaDisponibilidad;
    private String clienteId;
    private String partition;
    @CreatedDate
    private LocalDateTime fechaCreacion = LocalDateTime.now();
    private int prioridad;
    private boolean activo;
    private boolean descatado;
    private Servicio servicios;
    private Alrededores alrededores;
    private CaracteristicasGenerales caracteristicasGenerales;

    /**
     * Valida las características generales de un inmueble, asegurando que no sean nulas.
     */
    public void validateCaracteristicasGenerales() {
        if (this.caracteristicasGenerales == null) {
            this.caracteristicasGenerales = new CaracteristicasGenerales();
        }

        // Validar cada campo booleano, asegurando que nunca sean nulos.
        this.caracteristicasGenerales.setChimenea(this.caracteristicasGenerales.isChimenea());
        this.caracteristicasGenerales.setJardin(this.caracteristicasGenerales.isJardin());
        this.caracteristicasGenerales.setPiscina(this.caracteristicasGenerales.isPiscina());
        this.caracteristicasGenerales.setTerraza(this.caracteristicasGenerales.isTerraza());
        this.caracteristicasGenerales.setSeguridad(this.caracteristicasGenerales.isSeguridad());
        this.caracteristicasGenerales.setCercaColegios(this.caracteristicasGenerales.isCercaColegios());
        this.caracteristicasGenerales.setCloset(this.caracteristicasGenerales.isCloset());
        this.caracteristicasGenerales.setWalkInCloset(this.caracteristicasGenerales.isWalkInCloset());

        // Validar otros campos específicos si fuera necesario...
    }
}
