package com.example.demos.controller;

import com.example.demos.model.Inmueble;
import com.example.demos.repository.InmuebleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/portada")
@CrossOrigin(origins = "*")
public class PortadaController {

    @Autowired
    private InmuebleRepository inmuebleRepository;

    // Método GET para obtener todos los inmuebles
    @GetMapping
    public List<Inmueble> getAllInmuebles() {
        return (List<Inmueble>) inmuebleRepository.findAll();
    }

    // Método POST para agregar un nuevo inmueble
    @PostMapping
    public Inmueble createInmueble(@RequestBody Inmueble inmueble) {
        return inmuebleRepository.save(inmueble);
    }
}