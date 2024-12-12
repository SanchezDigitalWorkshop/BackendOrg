package com.example.demo.repository;

import com.example.demo.model.Job;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends MongoRepository<Job, String> {
    // Métodos personalizados si son necesarios
}