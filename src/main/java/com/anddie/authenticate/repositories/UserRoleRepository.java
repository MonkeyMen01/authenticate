package com.anddie.authenticate.repositories;

import com.anddie.authenticate.data.entities.UserRole;
import com.anddie.authenticate.data.entities.UserRoleId;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRoleRepository extends JpaRepository<UserRole, UserRoleId> {

    
}