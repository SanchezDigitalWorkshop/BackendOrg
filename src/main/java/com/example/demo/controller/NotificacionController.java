package com.example.demo.controller;

import com.example.demo.model.Notificacion;
import com.example.demo.repository.NotificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/notificaciones")
public class NotificacionController {
    @Autowired
    private NotificacionRepository notificacionRepository;

    @GetMapping
    public long getNumeroNotificaciones() {
        return notificacionRepository.findById("notificacionId")
                .map(Notificacion::getNumeroNotificaciones)
                .orElse(0L);
    }
}