package com.example.demos.controller;

import com.example.demos.model.Cliente;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/clientes")
public class ClienteController {

    @GetMapping
    public List<Cliente> getClientes() {
        return Arrays.asList(
                new Cliente("Bross", "Sanchez", "Bross.Sanchez@example.com"),
                new Cliente("Ana", "García", "ana.garcia@example.com"),
                new Cliente("Valdemar", "Martínez", "luis.martinez@example.com")
        );
    }
}