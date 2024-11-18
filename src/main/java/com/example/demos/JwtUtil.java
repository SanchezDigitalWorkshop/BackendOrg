package com.example.demos;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;

public class JwtUtil {
    private static final String BASE64_SECRET_KEY = "aC1OV6T4g/X3riH9dpE3l/G53hV8msh3LCN7pZZcXxBTG6Y4b9Mejc/DuCskq7HzWp/RIRpJpoG6FIVFiGVqZg==";
    public static final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(Base64.getDecoder().decode(BASE64_SECRET_KEY));

    public static String generateToken(String email, String role, String userId) {
        return Jwts.builder()
                .setSubject(email)
                .claim("userId", userId)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 día
                .signWith(SECRET_KEY, SignatureAlgorithm.HS512)
                .compact();
    }

    public static Claims validateToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY) // Usa la misma clave para validar
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}