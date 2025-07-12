package com.roundsquare.userservice.repository;

import com.roundsquare.userservice.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserServiceRepository extends JpaRepository<Users, Long> {
}
