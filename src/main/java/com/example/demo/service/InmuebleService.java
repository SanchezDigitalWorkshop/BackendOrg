package com.example.demo.service;

import com.example.demo.model.Inmueble;
import com.example.demo.repository.InmuebleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
