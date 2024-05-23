package com.anddie.authenticate.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class UserRoleId implements Serializable {
    private static final long serialVersionUID = 7504992670968176782L;
    @Column(name = "role_code", nullable = false)
    private Integer roleCode;

    @Column(name = "user_id", nullable = false, length = 36)
    private String userId;

    @Column(name = "role_name", nullable = false, length = 50)
    private String roleName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserRoleId entity = (UserRoleId) o;
        return Objects.equals(this.roleCode, entity.roleCode) &&
                Objects.equals(this.roleName, entity.roleName) &&
                Objects.equals(this.userId, entity.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleCode, roleName, userId);
    }

}