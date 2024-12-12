package com.example.demo.repository;

import com.example.demo.model.Inmueble;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InmuebleRepository extends MongoRepository<Inmueble, String> {
    // Puedes agregar métodos personalizados si es necesario
}