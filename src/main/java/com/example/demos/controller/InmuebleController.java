package com.example.demos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demos.model.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/inmuebles")
public class InmuebleController {

    @GetMapping
    public List<Inmueble> obtenerInmuebles() {
        return Arrays.asList(
                new Inmueble(1L, "Renta", "Casa", 150, 10000, "Av. Principal 123", 3, 2, "Casa en renta con excelente ubicación."),
                new Inmueble(2L, "Venta", "Terreno", 500, 500000, "Col. Industrial", 0, 0, "Terreno amplio ideal para construcción."),
                new Inmueble(3L, "Renta", "Mansión", 1000, 80000, "Zona exclusiva", 6, 5, "Mansión de lujo en zona exclusiva."),
                new Inmueble(4L, "Venta", "Casa", 200, 300000, "Calle Norte 45", 4, 3, "Casa en venta en zona residencial."),
                new Inmueble(5L, "Venta", "Terreno", 1000, 1200000, "Carretera Central", 0, 0, "Terreno ideal para proyectos grandes."),
                new Inmueble(6L, "Renta", "Departamento", 80, 7000, "Col. Centro", 2, 1, "Departamento céntrico a buen precio."),
                new Inmueble(7L, "Venta", "Mansión", 1500, 15000000, "Zona exclusiva", 8, 6, "Mansión de lujo con amplios jardines."),
                new Inmueble(8L, "Renta", "Casa", 100, 9000, "Av. Universidad", 3, 2, "Casa bien ubicada, cerca de transporte público."),
                new Inmueble(9L, "Venta", "Terreno", 150, 200000, "Zona periférica", 0, 0, "Terreno económico en zona de expansión."),
                new Inmueble(10L, "Venta", "Casa", 120, 250000, "Col. Obrera", 3, 1, "Casa económica para familia pequeña.")
        );
    }
}
