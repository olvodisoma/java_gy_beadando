package hu.nje.nb1.config;

import hu.nje.nb1.entity.Role;
import hu.nje.nb1.entity.User;
import hu.nje.nb1.repository.RoleRepository;
import hu.nje.nb1.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public DataInitializer(UserRepository userRepository,
                           RoleRepository roleRepository,
                           BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {

        // ---------- Admin role ----------
        Role adminRole = roleRepository.findByName("ROLE_ADMIN");
        if (adminRole == null) {
            adminRole = new Role();
            adminRole.setName("ROLE_ADMIN");
            roleRepository.save(adminRole);
            System.out.println("ROLE_ADMIN létrehozva.");
        }

        // ---------- Admin user ----------
        if (userRepository.findByUsername("admin") == null) {

            User admin = new User();
            admin.setUsername("admin");
            admin.setEmail("admin@admin.hu");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setEnabled(true);

            HashSet<Role> roles = new HashSet<>();
            roles.add(adminRole);

            admin.setRoles(roles);

            userRepository.save(admin);
            System.out.println("Admin user létrehozva: admin / admin123");
        }
    }
}

