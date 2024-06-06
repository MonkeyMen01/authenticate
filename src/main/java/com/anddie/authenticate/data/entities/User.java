package com.anddie.authenticate.data.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "user")
@Builder
public class User {
    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "phone", nullable = false, length = 10)
    private String phone;

    @ManyToMany(mappedBy = "users")
    private Set<Role> roles = new LinkedHashSet<>();

    public User() {

    }
}