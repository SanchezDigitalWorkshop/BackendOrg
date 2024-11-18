package com.example.demos.service;

import com.example.demos.JwtUtil;
import com.example.demos.RegisterRequest;
import com.example.demos.model.AuthResponse;
import com.example.demos.model.LoginRequest;
import com.example.demos.model.UpdateProfileRequest;
import com.example.demos.model.User;
import com.example.demos.repository.UserRepository;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public ResponseEntity<?> register(RegisterRequest request) {
        // Verificar si el email ya existe
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Email already exists");
        }

        // Crear y guardar el usuario
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword())); // Cifrar la contraseña
        user.setDni(request.getDni());
        user.setName(request.getName());
        user.setRole(request.getRole());

        userRepository.save(user);

        return ResponseEntity.ok("User registered successfully");
    }

    public ResponseEntity<?> authenticateUser(LoginRequest request) {
        Optional<User> userOpt = userRepository.findByEmail(request.getEmail());
        if (userOpt.isEmpty() || !passwordEncoder.matches(request.getPassword(), userOpt.get().getPassword())) {
            return ResponseEntity.status(401).body("Invalid email or password.");
        }

        User user = userOpt.get();
        String token = JwtUtil.generateToken(user.getEmail(), user.getRole(), user.getId());
        return ResponseEntity.ok(new AuthResponse(token));
    }

  /*  public ResponseEntity<?> getUserProfile(HttpServletRequest request) {
        Claims claims = (Claims) request.getAttribute("claims");
        String userId = claims.get("userId", String.class);

        Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isEmpty()) {
            return ResponseEntity.status(404).body("User not found.");
        }

        return ResponseEntity.ok(userOpt.get());
    }*/

    public ResponseEntity<?> getUserProfile(String dni) {


        Optional<User> userOpt = userRepository.findByDni(dni);
        if (userOpt.isEmpty()) {
            return ResponseEntity.status(404).body("User not found.");
        }

        return ResponseEntity.ok(userOpt.get());
    }

    public ResponseEntity<?> updateUserProfile(UpdateProfileRequest request, HttpServletRequest httpRequest) {
        Claims claims = (Claims) httpRequest.getAttribute("claims");
        String userId = claims.get("userId", String.class);

        Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isEmpty()) {
            return ResponseEntity.status(404).body("User not found.");
        }

        User user = userOpt.get();
        user.setName(request.getName());
        user.setProfile(request.getProfile());
        userRepository.save(user);

        return ResponseEntity.ok("Profile updated successfully.");
    }
}
