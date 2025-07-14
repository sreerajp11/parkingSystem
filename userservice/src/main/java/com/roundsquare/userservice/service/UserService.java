package com.roundsquare.userservice.service;

import com.roundsquare.userservice.entity.Users;

import java.util.List;

public interface UserService {
    Users saveUser(Users user);

    Users getUserById(Long id);

    List<Users> getAllUsers();

    Users findByEmail(String email);
}
