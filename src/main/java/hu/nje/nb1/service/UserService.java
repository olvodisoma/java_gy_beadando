package hu.nje.nb1.service;

import hu.nje.nb1.dto.RegistrationDto;
import hu.nje.nb1.entity.Role;
import hu.nje.nb1.entity.User;
import hu.nje.nb1.repository.RoleRepository;
import hu.nje.nb1.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                       RoleRepository roleRepository,
                       BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(RegistrationDto dto) {

        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setEnabled(true);

        // szerepkör beállítása
        Role userRole = roleRepository.findByName("ROLE_USER");

        // ha még nincs benne az adatbázisban → létrehozzuk
        if (userRole == null) {
            userRole = new Role();
            userRole.setName("ROLE_USER");
            roleRepository.save(userRole);
        }

        HashSet<Role> roles = new HashSet<>();
        roles.add(userRole);

        user.setRoles(roles);

        userRepository.save(user);
    }
}
