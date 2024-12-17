package com.example.demo.controller;

import com.example.demo.model.Inmueble;
import com.example.demo.repository.InmuebleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.List;

@RestController
@RequestMapping("api/inmuebles")
@CrossOrigin(origins = "*")
public class InmuebleController {

    @Autowired
    private InmuebleRepository inmuebleRepository;

    @ApiOperation(value = "Obtener todos los inmuebles", notes = "Devuelve una lista de todos los inmuebles disponibles")
    @GetMapping
    public List<Inmueble> getAllInmuebles() {
        return (List<Inmueble>) inmuebleRepository.findAll();
    }

    @ApiOperation(value = "Crear un nuevo inmueble", notes = "Crea un nuevo inmueble en la base de datos")
    @PostMapping
    public Inmueble createInmueble(@ApiParam(value = "Detalles del inmueble a crear", required = true) @RequestBody Inmueble inmueble) {
        return inmuebleRepository.save(inmueble);
    }
}
