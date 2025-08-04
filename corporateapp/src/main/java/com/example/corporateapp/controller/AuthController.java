package com.example.corporateapp.controller;

import com.example.corporateapp.dto.AuthRequest;
import com.example.corporateapp.dto.AuthResponse;
import com.example.corporateapp.model.Role;
import com.example.corporateapp.model.User;
import com.example.corporateapp.repository.UserRepository;
import com.example.corporateapp.security.JwtService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    // ✅ Normal kullanıcı (PERSONAL) kayıt olma
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> registerPersonal(@RequestBody AuthRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.PERSONAL) // PERSONAL rolü atanıyor
                .build();

        userRepository.save(user);

        String token = jwtService.generateToken(user);
        return ResponseEntity.ok(new AuthResponse(token));
    }

    // ✅ ADMIN rolüyle kayıt olma (Sadece ilk kurulum için kullanılabilir veya yetkili bir kullanıcı tarafından çağrılmalıdır)
    @PostMapping("/register/admin")
    public ResponseEntity<AuthResponse> registerAdmin(@RequestBody AuthRequest request) {
        // Not: Bu endpoint'in güvenliğini sağlamanız önemlidir.
        // Üretim ortamında bu şekilde herkese açık olmamalıdır.
        User adminUser = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.ADMIN) // ADMIN rolü atanıyor
                .build();

        userRepository.save(adminUser);

        String token = jwtService.generateToken(adminUser);
        return ResponseEntity.ok(new AuthResponse(token));
    }

    // ✅ HUMAN_RESOURCE rolüyle kayıt olma
    @PostMapping("/register/hr")
    public ResponseEntity<AuthResponse> registerHumanResource(@RequestBody AuthRequest request) {
        User hrUser = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.HUMAN_RESOURCE) // HUMAN_RESOURCE rolü atanıyor
                .build();

        userRepository.save(hrUser);

        String token = jwtService.generateToken(hrUser);
        return ResponseEntity.ok(new AuthResponse(token));
    }


    // ✅ Giriş yapma
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı"));

        String token = jwtService.generateToken(user);
        return ResponseEntity.ok(new AuthResponse(token));
    }
}