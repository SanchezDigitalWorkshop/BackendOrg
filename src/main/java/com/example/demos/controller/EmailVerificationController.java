package com.example.demos.controller;

import com.example.demos.service.EmailVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmailVerificationController {

    @Autowired
    private EmailVerificationService emailVerificationService;

    @PostMapping("/send-verification-email")
    public ResponseEntity<String> sendVerificationEmail(@RequestParam String userId, @RequestParam String email) {
        emailVerificationService.sendVerificationEmail(userId, email);
        return ResponseEntity.ok("Email de verificación enviado.");
    }

    @GetMapping("/verify-email")
    public ResponseEntity<String> verifyEmail(@RequestParam String token) {
        boolean isVerified = emailVerificationService.verifyToken(token);
        if (isVerified) {
            return ResponseEntity.ok("Correo verificado exitosamente.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Token inválido o expirado.");
        }
    }
}