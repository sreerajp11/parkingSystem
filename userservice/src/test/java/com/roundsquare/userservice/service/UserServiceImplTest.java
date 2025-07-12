package com.roundsquare.userservice.service;

import com.roundsquare.userservice.entity.Users;
import com.roundsquare.userservice.repository.UserServiceRepository;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Unit tests for {@link UserServiceImpl}.
 */
class UserServiceImplTest {
    private final UserServiceRepository repo = mock(UserServiceRepository.class);
    private final UserService userService = new UserServiceImpl(repo);


    @Test
    void testSaveUser() {
        Users user = mock(Users.class);
        when(repo.save(user)).thenReturn(user);
        when(user.getName()).thenReturn("Natalie");
        when(user.getEmail()).thenReturn("natalie@gmail.com");
        when(user.getPassword()).thenReturn("Nat123");

        Users expected = userService.saveUser(user);
        assertEquals("Natalie", expected.getName());
        assertEquals("Nat123", expected.getPassword());
    }

    @Test
    void testGetUserById() {
        Users user1 = mock(Users.class);
        Users user2 = mock(Users.class);
        when(repo.findById(1L)).thenReturn(Optional.of(user1));
        when(repo.findById(2L)).thenReturn(Optional.of(user2));

        when(user1.getName()).thenReturn("Natalie");
        when(user1.getId()).thenReturn(1L);
        when(user2.getName()).thenReturn("James");
        when(user2.getId()).thenReturn(2L);

        assertEquals("Natalie", userService.getUserById(1L).getName());
        assertEquals("James", userService.getUserById(2L).getName());

    }

    @Test
    void testGetAllUsers() {
        Users user1 = mock(Users.class);
        Users user2 = mock(Users.class);
        Users user3 = mock(Users.class);
        when(repo.findAll()).thenReturn(List.of(user1, user2, user3));

        assertEquals(3, userService.getAllUsers().size());
    }
}