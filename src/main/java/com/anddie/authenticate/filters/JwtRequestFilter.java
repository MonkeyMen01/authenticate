package com.anddie.authenticate.filters;

import com.anddie.authenticate.configs.security.LoadUserService;
import com.anddie.authenticate.utils.GlobalLogger;
import com.anddie.authenticate.utils.JwtTokenUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtRequestFilter extends OncePerRequestFilter {
    private JwtTokenUtil jwtTokenUtil;
    private LoadUserService loadUserService;

    public JwtRequestFilter(JwtTokenUtil jwtTokenUtil, LoadUserService loadUserService) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.loadUserService = loadUserService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String requestTokenHeader = request.getHeader("Authorization");

    }
}
