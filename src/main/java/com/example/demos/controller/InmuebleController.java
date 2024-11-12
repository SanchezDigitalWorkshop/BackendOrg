package com.example.demos.controller;

import com.example.demos.repository.InmuebleRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demos.model.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/inmuebles")
@CrossOrigin(origins = "*")
public class InmuebleController {

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