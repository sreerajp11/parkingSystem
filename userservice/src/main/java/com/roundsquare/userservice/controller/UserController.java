package com.roundsquare.userservice.controller;

import com.roundsquare.userservice.entity.Users;
import com.roundsquare.userservice.service.UserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {

    private UserServiceImpl userService;

    @Operation(summary = "Get all users")
    @GetMapping("/allUsers")
    public ResponseEntity<List<Users>> getAllUsers() {

        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }


    @Operation(summary = "Get user by ID")
    @GetMapping("/getUserById/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @Operation(summary = "Register a new user")
    @PostMapping("/register")
    public ResponseEntity<Users> saveUser(@Valid @RequestBody Users user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }
}