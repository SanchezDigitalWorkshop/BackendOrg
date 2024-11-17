package com.example.demos.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "email_verification_tokens")
public class EmailVerificationToken {
    @Id
    private String id;
    private String userId; // ID o DNI del usuario
    private String token; // Token único
    private LocalDateTime expiryDate; // Fecha de expiración del token
}
