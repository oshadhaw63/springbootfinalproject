package com.ijse.springboot.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ijse.springboot.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    Optional<User> findByUsername(String username);

    static Boolean existsByUsername(String username) {

        throw new UnsupportedOperationException("Unimplemented method 'existsByUsername'");
    }

    Boolean existsByEmail(String email);
}