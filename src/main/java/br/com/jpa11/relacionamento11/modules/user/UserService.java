package br.com.jpa11.relacionamento11.modules.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    public UserEntity create(UserEntity payload) {
        var user = userRepo.save(payload);
        return user;
    }

    public List<UserEntity> read() {
        return userRepo.findAll();
    }
}