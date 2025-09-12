package com.example.Auth.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Auth.dto.AuthRequest;
import com.example.Auth.dto.AuthResponse;
import com.example.Auth.models.User;
import com.example.Auth.repository.UserRepository;
import com.example.Auth.security.JwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepo;
    private final PasswordEncoder encoder;
    private final JwtService jwt;

    public AuthResponse register(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userRepo.save(user);
        String token = jwt.generateToken(user.getEmail());
        return new AuthResponse(token);
    }

    public AuthResponse login(AuthRequest request) {
        User user = userRepo.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));
        if (!encoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        String token = jwt.generateToken(user.getEmail());
        return new AuthResponse(token);
    }
}
