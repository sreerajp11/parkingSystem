package com.roundsquare.userservice.repository;

import com.roundsquare.userservice.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserServiceRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByEmail(String email);
}
