package com.example.demos.repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.example.demos.model.Inmueble;
import org.springframework.stereotype.Repository;

@Repository
public interface InmuebleRepository extends MongoRepository<Inmueble, String> {
    // Puedes agregar métodos personalizados si es necesario
}