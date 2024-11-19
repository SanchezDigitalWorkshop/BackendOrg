package com.example.demos.repository;

import com.example.demos.model.Job;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends MongoRepository<Job, String> {
    // Métodos personalizados si son necesarios
}