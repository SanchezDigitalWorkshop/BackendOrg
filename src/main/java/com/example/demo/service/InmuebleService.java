package com.example.demo.service;

import com.example.demo.model.Inmueble;
import com.example.demo.model.Notificacion;
import com.example.demo.repository.InmuebleRepository;
import com.example.demo.repository.NotificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class InmuebleService {

    @Autowired
    private InmuebleRepository inmuebleRepository;

    @Autowired
    private NotificacionRepository notificacionRepository;

    public Inmueble guardarInmueble(Inmueble inmueble) {
        Inmueble guardado = inmuebleRepository.save(inmueble);

        // Actualizar el número de notificaciones
        Notificacion notificacion = notificacionRepository.findById("notificacionId")
                .orElseGet(() -> {
                    Notificacion nueva = new Notificacion();
                    nueva.setId("notificacionId");
                    nueva.setNumeroNotificaciones(0);
                    return nueva;
                });

        notificacion.setNumeroNotificaciones(notificacion.getNumeroNotificaciones() + 1);
        notificacionRepository.save(notificacion);

        return guardado;
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
        LocalDateTime fechaInicio = LocalDateTime.now().minusDays(7);
        String fechaISO = fechaInicio.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);

        return inmuebleRepository.countByFechaCreacionAfter(fechaISO);
    }
    public List<Inmueble> guardarListaInmuebles(List<Inmueble> inmuebles) {
        inmuebles.forEach(Inmueble::validateCaracteristicasGenerales); // Validación de cada inmueble
        return inmuebleRepository.saveAll(inmuebles);
    }

    public void eliminarTodosLosInmuebles() {
        inmuebleRepository.deleteAll();
    }
}
