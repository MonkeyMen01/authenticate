package com.anddie.authenticate.data.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "role")
@IdClass(RoleId.class)
public class Role {

    @Id
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Id
    @Column(name = "code", nullable = false)
    private Integer code;

    @ManyToMany
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "role_name"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> users = new LinkedHashSet<>();

}