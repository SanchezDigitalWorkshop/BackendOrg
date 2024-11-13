package com.example.demos.controller;

import com.example.demos.model.Portada;
import com.example.demos.repository.PortadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/portada")
@CrossOrigin(origins = "*")
public class PortadaController {

    @Autowired
    private PortadaRepository portadaRepository;

    // Método GET para obtener todos los inmuebles
    @GetMapping
    public List<Portada> getAllInmuebles() {
        return (List<Portada>) portadaRepository.findAll();
    }

    // Método POST para agregar un nuevo inmueble
    @PostMapping
    public Portada createInmueble(@RequestBody Portada portada) {
        return portadaRepository.save(portada);
    }
}