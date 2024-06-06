package com.anddie.authenticate.data.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
public class RoleId implements Serializable {
    private static final long serialVersionUID = -7654521594645874129L;

    private String name;

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