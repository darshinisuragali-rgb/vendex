package com.vendex.service;

import com.vendex.dto.LoginRequestDTO;
import com.vendex.dto.LoginResponseDTO;
import com.vendex.dto.UserDTO;
import com.vendex.entity.User;
import com.vendex.exception.UnauthorizedException;
import com.vendex.repository.UserRepository;
import com.vendex.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * Authentication Service
 * Handles user authentication and JWT token generation
 */
@Service
@Transactional
public class AuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public LoginResponseDTO login(LoginRequestDTO request) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = tokenProvider.generateToken(authentication);

            User user = userRepository.findByEmail(request.getEmail())
                    .orElseThrow(() -> new UnauthorizedException("User not found"));
            
            user.setLastLogin(LocalDateTime.now());
            userRepository.save(user);

            UserDTO userDTO = UserDTO.builder()
                    .id(user.getId())
                    .email(user.getEmail())
                    .firstName(user.getFirstName())
                    .lastName(user.getLastName())
                    .role(user.getRole())
                    .build();

            return LoginResponseDTO.builder()
                    .token(token)
                    .tokenType("Bearer")
                    .expiresIn(86400L) // 24 hours
                    .user(userDTO)
                    .build();
        } catch (Exception e) {
            throw new UnauthorizedException("Invalid email or password");
        }
    }

    public String getCurrentUserEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            return authentication.getName();
        }
        throw new UnauthorizedException("User not authenticated");
    }
}
