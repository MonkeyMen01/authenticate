package com.anddie.authenticate.repositories;

import com.anddie.authenticate.data.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}