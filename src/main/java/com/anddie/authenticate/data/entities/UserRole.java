package com.anddie.authenticate.data.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user_role")
@IdClass(UserRoleId.class)
public class UserRole {
    @Id
    @Column(name = "role_code", nullable = false)
    private Integer roleCode;

    @Id
    @Column(name = "user_id", nullable = false, length = 36)
    private String userId;

    @Id
    @Column(name = "role_name", nullable = false, length = 50)
    private String roleName;

}