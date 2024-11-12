package com.example.demos.repository;

import com.example.demos.model.Inmueble;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InmuebleRepository extends MongoRepository<Inmueble, String> {
    // Puedes agregar métodos personalizados si es necesario
}