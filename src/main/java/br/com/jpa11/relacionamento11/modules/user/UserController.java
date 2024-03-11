package br.com.jpa11.relacionamento11.modules.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody UserEntity payload) {
        var user = userService.create(payload);
        return ResponseEntity.status(201).body(user);
    }

    @GetMapping
    public ResponseEntity<?> read() {
        var users = userService.read();
        return ResponseEntity.status(200).body(users);
    }
}