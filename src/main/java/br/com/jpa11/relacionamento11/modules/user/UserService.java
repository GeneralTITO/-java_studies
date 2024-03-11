package br.com.jpa11.relacionamento11.modules.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jpa11.relacionamento11.modules.profile.ProfileRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private ProfileRepository profileRepo;

    public UserEntity create(UserEntity payload) {
        var profileData = payload.getProfile();

        if (profileData == null) {
            var user = userRepo.save(payload);
            return user;
        }

        var profile = profileRepo.save(profileData);
        payload.setProfile(profile);

        var user = userRepo.save(payload);

        return user;
    }

    public List<UserEntity> read() {
        return userRepo.findAll();
    }
}