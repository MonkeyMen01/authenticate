package com.anddie.authenticate.repositories;

import com.anddie.authenticate.data.entities.UserRole;
import com.anddie.authenticate.data.entities.UserRoleId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, UserRoleId> {
}