package com.example.demos.service;

import com.example.demos.model.EmailVerificationToken;
import com.example.demos.repository.EmailVerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmailVerificationService {

    @Autowired
    private EmailVerificationTokenRepository tokenRepository;

    @Autowired
    private JavaMailSender mailSender;

    public void sendVerificationEmail(String userId, String email) {
        // Generar token único
        String token = UUID.randomUUID().toString();

        // Crear y guardar el token
        EmailVerificationToken verificationToken = new EmailVerificationToken();
        verificationToken.setUserId(userId);
        verificationToken.setToken(token);
        verificationToken.setExpiryDate(LocalDateTime.now().plusHours(24)); // Token válido por 24 horas
        tokenRepository.save(verificationToken);

        // Enviar correo
        String link = "https://ms-generic-client-prd-hycqhqdzgahya8cb.canadacentral-01.azurewebsites.net/api/verify-email?token=" + token;
        String subject = "Verifica tu correo electrónico";
        String body = "Por favor haz clic en el siguiente enlace para verificar tu correo: " + link;

        sendEmail(email, subject, body);
    }

    private void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }

    public boolean verifyToken(String token) {
        Optional<EmailVerificationToken> optionalToken = tokenRepository.findByToken(token);
        if (optionalToken.isPresent()) {
            EmailVerificationToken verificationToken = optionalToken.get();
            if (verificationToken.getExpiryDate().isAfter(LocalDateTime.now())) {
                // Token válido, eliminarlo después de verificar
                tokenRepository.delete(verificationToken);
                return true;
            }
        }
        return false;
    }
}