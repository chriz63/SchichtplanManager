package com.github.chriz63.SchichtplanManager.configuration;

import com.github.chriz63.SchichtplanManager.model.SpMgrUser;
import com.github.chriz63.SchichtplanManager.repository.SpMgrUserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DatabaseInit {

    private final SpMgrUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DatabaseInit (SpMgrUserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void initAdminUser() {
        String adminName = System.getenv("ADMIN_USER");
        String adminPassword = System.getenv("ADMIN_PASSWORD");
        if (adminName != null && adminPassword != null) {
            if (!userRepository.existsByName(adminName)) {
                SpMgrUser admin = new SpMgrUser();
                admin.setName(adminName);
                admin.setPassword(passwordEncoder.encode(adminPassword));
                admin.setRole("ROLE_ADMIN");
                userRepository.save(admin);
            }
        }
    }
}
