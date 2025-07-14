package com.roundsquare.userservice.service;

import com.roundsquare.userservice.entity.Users;
import com.roundsquare.userservice.repository.UserServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserServiceRepository repo;

    public UserServiceImpl(UserServiceRepository repo) {
        this.repo = repo;
    }


    @Override
    public Users saveUser(Users user) {
        return repo.save(user);
    }

    @Override
    public Users getUserById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    @Override
    public List<Users> getAllUsers() {
        return repo.findAll();
    }

    @Override
    public Users findByEmailAndPassword(String email) {
        return repo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
    }
}
