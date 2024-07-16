package com.example.hotel.serviceImpl;

import com.example.hotel.domain.Role;
import com.example.hotel.domain.User;
import com.example.hotel.dto.UserDto;
import com.example.hotel.repository.RoleRepository;
import com.example.hotel.repository.UserRepository;
import com.example.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User save(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
       // Fetch the role with ID 2 and set it to the user
       Role userRole = roleRepository.findById(2L).orElseThrow(() -> new RuntimeException("Role not found"));
       user.setRole(userRole);
        return userRepository.save(user);
    }
    
    

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return org.springframework.security.core.userdetails.User.withUsername(user.getUsername())
                .password(user.getPassword())
                .authorities("ROLE_" + user.getRole().getRolename())
                .build();
    }
}
