package com.anddie.authenticate.configs;

import com.anddie.authenticate.data.entities.Role;
import com.anddie.authenticate.data.entities.User;
import com.anddie.authenticate.data.entities.UserRole;
import com.anddie.authenticate.repositories.RoleRepository;
import com.anddie.authenticate.repositories.UserRepository;
import com.anddie.authenticate.repositories.UserRoleRepository;
import com.anddie.authenticate.utils.GlobalLogger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Component
public class Init extends GlobalLogger implements CommandLineRunner {
    private final UserRoleRepository userRoleRepository;
    private RoleRepository roleRepository;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private static final String ROLE_ADMIN = "ADMIN";
    private static final String ROLE_USER = "USER";
    @Value("${init.email}")
    private String INIT_EMAIL;
    @Value("${init.password}")
    private String INIT_PASSWORD;

    public Init(PasswordEncoder passwordEncoder, UserRepository userRepository, RoleRepository roleRepository, UserRoleRepository userRoleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userRoleRepository = userRoleRepository;
    }

    @Transactional
    @Override
    public void run(String... args) {
        try {
            List<Role> roles = roleRepository.findAll();

            if (roles.isEmpty()) {
                roles = roleRepository.saveAll(List.of(
                        Role.builder().code(32).name(ROLE_ADMIN).build(),
                        Role.builder().code(4).name(ROLE_USER).build()
                ));
            }

            List<User> users = userRepository.findAll();
            if (users.size() == 0) {
                Role adminRole = roles.stream().filter(role -> role.getName().equals(ROLE_ADMIN))
                        .findFirst().orElseThrow();
               User initUser =  userRepository.save(
                        User.builder().name("")
                                .email(INIT_EMAIL)
                                .password(passwordEncoder.encode(INIT_PASSWORD))
                                .phone("")
                                .build()
                );
                userRoleRepository.save(UserRole.builder()
                                .roleCode(adminRole.getCode())
                                .roleName(adminRole.getName())
                                .userId(initUser.getId())
                        .build());
            }
        } catch (TransactionException e) {
            logger.error("Error in init-> {}", e.getMessage(),e);
        }
    }
}
