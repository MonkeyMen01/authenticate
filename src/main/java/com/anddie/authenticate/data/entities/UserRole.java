package com.anddie.authenticate.data.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "user_role")
@IdClass(UserRoleId.class)
@Builder
@NoArgsConstructor
@AllArgsConstructor
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