package com.example.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hotel.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}