package com.example.demo.service;

import com.example.demo.model.Plan;
import com.example.demo.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PlanService {

    @Autowired
    private PlanRepository planRepository;

    public List<Plan> findAll() {
        return planRepository.findAll();
    }

    public Optional<Plan> findById(String id) {
        return planRepository.findById(id);
    }

    public Plan save(Plan plan) {
        plan.setFechaCreacion(LocalDateTime.now());
        plan.setFechaActualizacion(LocalDateTime.now());
        return planRepository.save(plan);
    }

    public Plan update(String id, Plan plan) {
        Optional<Plan> existingPlan = planRepository.findById(id);
        if (existingPlan.isPresent()) {
            Plan updatedPlan = existingPlan.get();
            updatedPlan.setNombrePlan(plan.getNombrePlan());
            updatedPlan.setDescripcion(plan.getDescripcion());
            updatedPlan.setMonto(plan.getMonto());
            updatedPlan.setMetodosPago(plan.getMetodosPago());
            updatedPlan.setEstado(plan.getEstado());
            updatedPlan.setFechaActualizacion(LocalDateTime.now());
            return planRepository.save(updatedPlan);
        }
        throw new RuntimeException("Plan no encontrado");
    }

    public void delete(String id) {
        planRepository.deleteById(id);
    }

    public List<Plan> findTop5() {
        return planRepository.findTop5ByOrderByFechaCreacionDesc();
    }
}
