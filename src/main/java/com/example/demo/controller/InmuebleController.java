package com.example.demo.controller;

import com.example.demo.model.Inmueble;
import com.example.demo.service.InmuebleService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @ApiOperation(value = "Eliminar todos los inmuebles", notes = "Elimina todos los inmuebles de la base de datos")
    @DeleteMapping("/lista")
    public ResponseEntity<Void> deleteAllInmuebles() {
        inmuebleService.eliminarTodosLosInmuebles();
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Crear múltiples inmuebles", notes = "Crea múltiples inmuebles en la base de datos")
    @PostMapping("/lista")
    public ResponseEntity<List<Inmueble>> createInmuebles(
            @ApiParam(value = "Lista de inmuebles a crear", required = true) @RequestBody List<Inmueble> inmuebles) {
        List<Inmueble> inmueblesGuardados = inmuebleService.guardarListaInmuebles(inmuebles);
        return ResponseEntity.ok(inmueblesGuardados);
    }

    @ApiOperation(value = "Obtener los últimos N inmuebles", notes = "Devuelve una lista con los últimos inmuebles añadidos a la base de datos")
    @GetMapping("/ultimos")
    public ResponseEntity<List<Inmueble>> getUltimosInmuebles(@RequestParam(defaultValue = "7") int limite) {
        List<Inmueble> ultimosInmuebles = inmuebleService.obtenerUltimosInmuebles(limite);
        return ResponseEntity.ok(ultimosInmuebles);
    }

    @ApiOperation(value = "Obtener inmuebles con tiempo de publicación", notes = "Devuelve una lista de inmuebles junto con el tiempo transcurrido desde su publicación")
    @GetMapping("/tiempo-publicacion")
    public ResponseEntity<List<Map<String, Object>>> getInmueblesConTiempoPublicacion() {
        List<Map<String, Object>> inmueblesConTiempo = inmuebleService.listarInmueblesConTiempoPublicacion();
        return ResponseEntity.ok(inmueblesConTiempo);
    }
}
