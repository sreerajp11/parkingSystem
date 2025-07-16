package com.example.parkingservice.client;

import com.example.parkingservice.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service")
public interface UserClient {

    @GetMapping("users/{id}")
    UserDTO getUserById(@PathVariable Long id);

}

