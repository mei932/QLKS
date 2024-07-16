package com.example.hotel.dto;

public class UserDto {
    private Long id;

    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

     public UserDto(Long id, String userName, String userPassword) {
        this.id = id;
        this.username = userName;
        this.password = userPassword;
    }

}
