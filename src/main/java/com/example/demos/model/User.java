package com.example.demos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "Users")
public class User {
    @Id
    private String id;
    private String email;
    private String password;
    private String dni;
    private String name;
    private String role; // persona, inmobiliario, admin, etc.
    private Profile profile;

    public User() {
        this.id = UUID.randomUUID().toString();
    }

    public User(String email, String password, String dni, String name, String role) {
        this.id = UUID.randomUUID().toString(); // Generar un ID único si está vacío
        this.email = email;
        this.password = password;
        this.dni = dni;
        this.name = name;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
