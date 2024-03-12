package br.com.kenzie.jwt_auth_pt1.modules.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepository userRepo;

    @GetMapping
    public ResponseEntity<?> read() {
        return ResponseEntity.status(200).body(userRepo.findAll());
    }
}
