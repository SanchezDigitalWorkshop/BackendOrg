package com.example.demo.repository;

import com.example.demo.model.Portada;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortadaRepository extends MongoRepository<Portada, String> {
    // Puedes agregar métodos personalizados si es necesario
}