package com.example.hotel.service;

import com.example.hotel.domain.User;
import com.example.hotel.dto.UserDto;

public interface UserService {
  User save(UserDto userDto);
    User findByUsername(String username);
}
