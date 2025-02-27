package com.example.demo.controller;

import com.example.demo.model.Portada;
import com.example.demo.repository.PortadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/portada")
@CrossOrigin(origins = "*")
public class PortadaController {

    @Autowired
    private PortadaRepository portadaRepository;

    // Método GET para obtener todos los getAllIPortada
    @GetMapping
    public List<Portada> getAllIPortada() {
        return (List<Portada>) portadaRepository.findAll();
    }

    // Método POST para agregar un nuevo createPortada
    @PostMapping
    public Portada createPortada(@RequestBody Portada portada) {
        return portadaRepository.save(portada);
    }
}