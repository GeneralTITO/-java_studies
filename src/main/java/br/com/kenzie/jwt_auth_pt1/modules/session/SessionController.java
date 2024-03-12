package br.com.kenzie.jwt_auth_pt1.modules.session;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class SessionController {
    @PostMapping("/register")
    public ResponseEntity<?> register() {
        return ResponseEntity.status(201).body("Rota de registro!");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login() {
        return ResponseEntity.status(200).body("Rota de login!");
    }
}
