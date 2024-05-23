package com.anddie.authenticate.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user_role")
public class UserRole {
    @EmbeddedId
    private UserRoleId id;

    @MapsId("id")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Role role;

    @MapsId("userId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}