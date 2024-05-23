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
public class RoleId implements Serializable {
    private static final long serialVersionUID = -7654521594645874129L;
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "code", nullable = false)
    private Integer code;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RoleId entity = (RoleId) o;
        return Objects.equals(this.code, entity.code) &&
                Objects.equals(this.name, entity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name);
    }

}