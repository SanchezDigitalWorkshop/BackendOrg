package com.example.demo.service;

import com.example.demo.model.Inmueble;
import com.example.demo.repository.InmuebleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class InmuebleService {

    @Autowired
    private InmuebleRepository inmuebleRepository;

    public Inmueble guardarInmueble(Inmueble inmueble) {
        inmueble.validateCaracteristicasGenerales();
        return inmuebleRepository.save(inmueble);
    }

    public List<Inmueble> listarTodos() {
        return inmuebleRepository.findAll();
    }

    public Inmueble buscarPorId(String id) {
        return inmuebleRepository.findById(id).orElse(null);
    }

    public boolean eliminarInmueble(String id) {
        Optional<Inmueble> inmueble = inmuebleRepository.findById(id);
        if (inmueble.isPresent()) {
            inmuebleRepository.deleteById(id);
            return true;
        }
        return false;
    }


    public long countInmueblesUltimaSemana() {
        LocalDateTime oneWeekAgo = LocalDateTime.now().minusDays(7);
        return inmuebleRepository.countByFechaCreacionAfter(oneWeekAgo);
    }
    public List<Inmueble> guardarListaInmuebles(List<Inmueble> inmuebles) {
        inmuebles.forEach(Inmueble::validateCaracteristicasGenerales); // Validación de cada inmueble
        return inmuebleRepository.saveAll(inmuebles);
    }

    public void eliminarTodosLosInmuebles() {
        inmuebleRepository.deleteAll();
    }
}
