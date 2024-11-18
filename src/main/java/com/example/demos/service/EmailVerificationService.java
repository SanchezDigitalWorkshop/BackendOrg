package com.example.demos.service;

import com.example.demos.model.EmailVerificationToken;
import com.example.demos.repository.EmailVerificationTokenRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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

        // Enviar correo con HTML personalizado
        String link = "https://ms-generic-client-prd-hycqhqdzgahya8cb.canadacentral-01.azurewebsites.net/api/verify-email?token=" + token;
        String subject = "Verifica tu correo electrónico";
        String body = """
            <html dir="ltr" xmlns="http://www.w3.org/1999/xhtml" xmlns:o="urn:schemas-microsoft-com:office:office">
              <head>
                <meta charset="UTF-8">
                <meta content="width=device-width, initial-scale=1" name="viewport">
                <meta name="x-apple-disable-message-reformatting">
                <meta http-equiv="X-UA-Compatible" content="IE=edge">
                <meta content="telephone=no" name="format-detection">
                <title>Verifica tu correo</title>
                <link href="https://fonts.googleapis.com/css2?family=Imprima&display=swap" rel="stylesheet">
                <style>
                  body {
                    font-family: 'Imprima', sans-serif;
                    background-color: #f3f3f3;
                    color: #333;
                  }
                  .email-container {
                    max-width: 600px;
                    margin: 0 auto;
                    background: #ffffff;
                    border-radius: 10px;
                    padding: 20px;
                  }
                  .header-logo {
                    text-align: center;
                    margin-bottom: 20px;
                  }
                  .button {
                    display: inline-block;
                    background-color: #7630f3;
                    color: #ffffff;
                    padding: 15px 25px;
                    text-align: center;
                    text-decoration: none;
                    border-radius: 5px;
                    font-weight: bold;
                  }
                  .footer {
                    text-align: center;
                    margin-top: 20px;
                    font-size: 12px;
                    color: #777;
                  }
                </style>
              </head>
              <body>
                <div class="email-container">
                  <div class="header-logo">
                    <img src="https://tlr.stripocdn.email/content/guids/CABINET_055ba03e85e991c70304fecd78a2dceaf6b3f0bc1b0eb49336463d3599679494/images/vector.png" alt="Logo" height="60">
                  </div>
                  <h3>Bienvenido,</h3>
                  <p>Gracias por registrarte en nuestro servicio. Por favor, haz clic en el siguiente botón para verificar tu correo electrónico y activar tu cuenta:</p>
                  <p style="text-align: center;">
                    <a href="%s" class="button">Verificar correo</a>
                  </p>
                  <p>Si no solicitaste esta verificación, por favor ignora este correo electrónico.</p>
                  <div class="footer">
                    <p>Gracias,<br>El equipo de la Inmobiliaria</p>
                  </div>
                </div>
              </body>
            </html>
            """.formatted(link);

        sendEmail(email, subject, body);
    }

    private void sendEmail(String to, String subject, String body) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setText(body, true); // Segundo parámetro 'true' indica que es HTML
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setFrom("SanchezDigitalWorkshop@gmail.com");
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            throw new IllegalStateException("Error al enviar el correo electrónico", e);
        }
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