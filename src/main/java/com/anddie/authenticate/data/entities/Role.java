package com.anddie.authenticate.data.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "role")
@IdClass(RoleId.class)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Id
    @Column(name = "code", nullable = false)
    private Integer code;

    @ManyToMany
    @JoinTable(name = "user_role",
            joinColumns ={
                    @JoinColumn(name = "role_name"),
                    @JoinColumn(name = "role_code")
            },
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> users = new LinkedHashSet<>();

}