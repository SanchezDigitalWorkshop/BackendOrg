package com.example.demo.controller;

import com.example.demo.model.Inmueble;
import com.example.demo.service.InmuebleService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/inmuebles")
@CrossOrigin(origins = "*")
public class InmuebleController {

    @Autowired
    private InmuebleService inmuebleService;

    @ApiOperation(value = "Obtener todos los inmuebles", notes = "Devuelve una lista de todos los inmuebles disponibles")
    @GetMapping
    public ResponseEntity<List<Inmueble>> getAllInmuebles() {
        List<Inmueble> inmuebles = inmuebleService.listarTodos();
        return ResponseEntity.ok(inmuebles);
    }

    @ApiOperation(value = "Crear un nuevo inmueble", notes = "Crea un nuevo inmueble en la base de datos")
    @PostMapping
    public ResponseEntity<Inmueble> createInmueble(
            @ApiParam(value = "Detalles del inmueble a crear", required = true) @RequestBody Inmueble inmueble) {
        Inmueble inmuebleGuardado = inmuebleService.guardarInmueble(inmueble);
        return ResponseEntity.ok(inmuebleGuardado);
    }

    @ApiOperation(value = "Obtener un inmueble por ID", notes = "Devuelve los detalles de un inmueble específico")
    @GetMapping("/{id}")
    public ResponseEntity<Inmueble> getInmuebleById(
            @ApiParam(value = "ID del inmueble a buscar", required = true) @PathVariable String id) {
        Inmueble inmueble = inmuebleService.buscarPorId(id);
        if (inmueble != null) {
            return ResponseEntity.ok(inmueble);
        }
        return ResponseEntity.notFound().build();
    }

    @ApiOperation(value = "Eliminar un inmueble por ID", notes = "Elimina un inmueble específico de la base de datos")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInmueble(
            @ApiParam(value = "ID del inmueble a eliminar", required = true) @PathVariable String id) {
        if (inmuebleService.eliminarInmueble(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
