package org.verigo.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.verigo.server.data.entities.User;
import org.verigo.server.data.repositories.UserRepository;
import org.verigo.server.mailer.EmailService;
import org.verigo.server.payloads.requests.LoginRequest;
import org.verigo.server.payloads.requests.SignupRequest;
import org.verigo.server.payloads.responses.JwtResponse;
import org.verigo.server.payloads.responses.MessageResponse;
import org.verigo.server.security.jwt.JwtUtils;
import org.verigo.server.security.services.CustomUserDetails;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    private EmailService emailService;

    @PostMapping("/sign-in")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginRequest.getLogin(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        String role = userDetails.getAuthorities().stream()
            .map(item -> item.getAuthority())
            .collect(Collectors.toList()).get(0);

        return ResponseEntity.ok(new JwtResponse(jwt,
            userDetails.getId(),
            userDetails.getUsername(),
            role));
    }

    @PostMapping("/sign-up")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByLogin(signUpRequest.getLogin())) {
            return ResponseEntity
                .badRequest()
                .body(new MessageResponse("Ошибка: Данный логин уже используется!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                .badRequest()
                .body(new MessageResponse("Ошибка: Данный адрес электронной почты уже используется!"));
        }

        User user = new User(
            signUpRequest.getLogin(),
            signUpRequest.getPassword(),
            signUpRequest.getEmail(),
            signUpRequest.getSurname(),
            signUpRequest.getRole()
        );

        userRepository.save(user);

        try {
            emailService.sendMail(user);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok(new MessageResponse("Пользователь успешно зарегистрирован!"));
    }
}
