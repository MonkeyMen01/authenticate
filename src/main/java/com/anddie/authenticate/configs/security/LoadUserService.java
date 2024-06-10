package com.anddie.authenticate.configs.security;

import com.anddie.authenticate.data.entities.User;
import com.anddie.authenticate.repositories.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

@Component
public class LoadUserService implements UserDetailsService {
    private UserRepository  userRepository;
    private PasswordEncoder passwordEncoder;

    public LoadUserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user  =userRepository.findUserByEmail(email).orElseThrow();

        List<GrantedAuthority> authorities = new ArrayList<>();
        return new org.springframework.security.core.userdetails.User(email,user.getPassword(),authorities);
    }


}
