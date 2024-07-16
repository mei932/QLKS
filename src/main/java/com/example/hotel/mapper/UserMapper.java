package com.example.hotel.mapper;

import com.example.hotel.domain.User;
import com.example.hotel.dto.UserDto;

public class UserMapper {
     public  UserDto mapToUsertDto(User user)
   {
        return new UserDto(user.getId(), user.getUsername(),user.getPassword());
   }
}
