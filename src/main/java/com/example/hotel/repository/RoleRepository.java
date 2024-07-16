package com.example.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hotel.domain.Role;

public interface RoleRepository  extends JpaRepository<Role, Long> {
    Role findByRolename(String rolename);
}
