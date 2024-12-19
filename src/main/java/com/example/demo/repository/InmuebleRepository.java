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
    @Query("SELECT COUNT(i) FROM Inmueble i WHERE i.fechaCreacion >= :startDate")
    long countByFechaCreacionAfter(@Param("startDate") LocalDateTime startDate);

}