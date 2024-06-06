package com.anddie.authenticate.repositories;

import com.anddie.authenticate.data.entities.Role;
import com.anddie.authenticate.data.entities.RoleId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, RoleId> {

}