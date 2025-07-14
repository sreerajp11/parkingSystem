package com.roundsquare.userservice.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Schema(name = "Users", description = "Entity representing a user in the system")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name cannot be null")
    private String name;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email should be valid")

    @Schema(description = "Email id", example = "britas@gmail.com")
    @Column(unique = true)
    private String email;

    @Schema(description = "Password of the user", minLength = 6)
    private String password;
    private String role;


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
}
