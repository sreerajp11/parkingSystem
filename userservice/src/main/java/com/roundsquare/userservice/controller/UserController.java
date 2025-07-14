package com.roundsquare.userservice.controller;

import com.roundsquare.userservice.dto.LoginRequest;
import com.roundsquare.userservice.entity.Users;
import com.roundsquare.userservice.service.UserServiceImpl;
import com.roundsquare.userservice.util.JwtUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RequestMapping("/users")
@RestController
@Tag(name = "User controller", description = "Operations related to user management")
@Validated
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private JwtUtil jwtUtil;

    @Operation(summary = "Get all users", description = "Fetches a list of all registered users, required JWT")
    @ApiResponse(responseCode = "200", description = "Returns list of all users")
    @GetMapping("/allUsers")
    public ResponseEntity<List<Users>> getAllUsers() {

        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }


    @Operation(summary = "Get user by ID,requires JWT")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "User found"),
            @ApiResponse(responseCode = "404", description = "User not found")})
    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@Parameter(description = "ID of user to be fetched") @PathVariable Long id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @Operation(summary = "Register a new user")
    @PostMapping("/register")
    public ResponseEntity<Users> regUser(@Valid @RequestBody Users user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }


    @PostMapping("/login")
    @Operation(summary = "User login", description = "Logs in a user with provided credentials")
    public ResponseEntity<?> login(@RequestBody LoginRequest login)
    {
        Users user = userService.findByEmail(login.getEmail());
        if(user == null || !user.getPassword().equals(login.getPassword()))
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
        String token = jwtUtil.generateToken(user.getEmail(), user.getRole());
        return ResponseEntity.ok(Collections.singletonMap("token", token));
    }
}