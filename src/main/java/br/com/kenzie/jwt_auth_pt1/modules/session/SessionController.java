package br.com.kenzie.jwt_auth_pt1.modules.session;

import java.util.Arrays;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.kenzie.jwt_auth_pt1.modules.user.UserEntity;
import br.com.kenzie.jwt_auth_pt1.modules.user.UserRepository;
import br.com.kenzie.jwt_auth_pt1.security.JwtTokenProvider;

@RestController
@RequestMapping("/api/auth")
public class SessionController {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserEntity payload) {
        var foundUser = userRepo.findByUsername(payload.getUsername());

        
        if (foundUser.isPresent()) {
            var msg = new HashMap<String, String>();
            msg.put("error", "Username already exists");
            return ResponseEntity.status(409).body(msg);
        }
        var userBuilder = UserEntity.builder()
                .username(payload.getUsername())
                .password(payload.getPassword())
                .admin(payload.getAdmin());

        if (payload.getAdmin()) {
            var adminRole = Arrays.asList("ADMIN");
            var admin = userBuilder.roles(adminRole).build();

            var user = userRepo.save(admin);

            return ResponseEntity.status(201).body(user);
        }

        var commomRole = Arrays.asList("COMMON");
        var common = userBuilder.roles(commomRole).build();

        var user = userRepo.save(common);

        return ResponseEntity.status(201).body(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserEntity payload) {
        var authToken = new UsernamePasswordAuthenticationToken(
                payload.getUsername(), payload.getPassword());
        var authentication = authenticationManager.authenticate(authToken);
        var token = jwtTokenProvider.createToken(authentication);

        var msg = new HashMap<String, String>();
        msg.put("token", token);

        return ResponseEntity.status(200).body(msg);
    }
}