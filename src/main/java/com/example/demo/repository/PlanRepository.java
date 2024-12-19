package com.example.demo.repository;

import com.example.demo.model.Plan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanRepository extends MongoRepository<Plan, String> {
    // Busca planes por estado
    List<Plan> findByEstado(String estado);

    // Obtiene los planes más recientes
    List<Plan> findTop5ByOrderByFechaCreacionDesc();
}
