package com.example.demo.repository;

import com.example.demo.model.Inmueble;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface InmuebleRepository extends MongoRepository<Inmueble, String> {
    // Puedes agregar métodos personalizados si es necesario
    @Query("{ 'fechaCreacion' : { $gte: ?0 } }")
    Long countByFechaCreacionAfter(String fechaCreacion);

}