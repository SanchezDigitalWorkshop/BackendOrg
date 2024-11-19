package com.example.demos.controller;

import com.example.demos.model.Job;
import com.example.demos.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/jobs")
public class JobController {

    @Autowired
    private JobRepository jobRepository;

    // Obtener todos los empleos
    @GetMapping
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    // Crear un empleo
    @PostMapping
    public Job createJob(@RequestBody Job job) {
        return jobRepository.save(job);
    }

    // Obtener un empleo por ID
    @GetMapping("/{id}")
    public Job getJobById(@PathVariable String id) {
        return jobRepository.findById(id).orElseThrow(() -> new RuntimeException("Empleo no encontrado"));
    }

    // Actualizar un empleo
    @PutMapping("/{id}")
    public Job updateJob(@PathVariable String id, @RequestBody Job jobDetails) {
        Job job = jobRepository.findById(id).orElseThrow(() -> new RuntimeException("Empleo no encontrado"));
        job.setNombreEmpleo(jobDetails.getNombreEmpleo());
        job.setFotoEmpleo(jobDetails.getFotoEmpleo());
        job.setLugar(jobDetails.getLugar());
        job.setTelefono(jobDetails.getTelefono());
        job.setTiempo(jobDetails.getTiempo());
        job.setVacantes(jobDetails.getVacantes());
        job.setPago(jobDetails.getPago());
        return jobRepository.save(job);
    }

    // Eliminar un empleo
    @DeleteMapping("/{id}")
    public String deleteJob(@PathVariable String id) {
        jobRepository.deleteById(id);
        return "Empleo eliminado con éxito";
    }
}