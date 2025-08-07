package com.example.corporateapp.repository;

import com.example.corporateapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username); // JWT için lazım olacak
}
