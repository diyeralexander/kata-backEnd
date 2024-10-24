package com.dmore.app.springbootcrud.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.dmore.app.springbootcrud.entities.Role;
import com.dmore.app.springbootcrud.entities.User;
import com.dmore.app.springbootcrud.repositories.RolReposiroty;
import com.dmore.app.springbootcrud.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private RolReposiroty rolReposiroty;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testFindAll() {
        List<User> users = new ArrayList<>();
        users.add(new User());
        when(userRepository.findAll()).thenReturn(users);

        List<User> result = userService.findAll();
        assertEquals(1, result.size());
    }

    @Test
    void testSaveAdminUser() {
        User user = new User();
        user.setAdmin(true);
        user.setPassword("password");

        Role adminRole = new Role();
        adminRole.setName("ROLE_ADMIN");

        when(rolReposiroty.findByName("ROLE_ADMIN")).thenReturn(Optional.of(adminRole));
        when(passwordEncoder.encode(any(String.class))).thenReturn("encodedPassword");
        when(userRepository.save(any(User.class))).thenReturn(user);

        User result = userService.save(user);

        assertEquals("encodedPassword", result.getPassword());
        assertEquals(1, result.getRoles().size());
        assertEquals("ROLE_ADMIN", result.getRoles().get(0).getName());
    }

    @Test
    void testSaveNonAdminUser() {
        User user = new User();
        user.setAdmin(false);
        user.setPassword("password");

        Role userRole = new Role();
        userRole.setName("ROLE_USER");

        when(rolReposiroty.findByName("ROLE_USER")).thenReturn(Optional.of(userRole));
        when(passwordEncoder.encode(any(String.class))).thenReturn("encodedPassword");
        when(userRepository.save(any(User.class))).thenReturn(user);

        User result = userService.save(user);

        assertEquals("encodedPassword", result.getPassword());
        assertEquals(1, result.getRoles().size());
        assertEquals("ROLE_USER", result.getRoles().get(0).getName());
    }

    @Test
    void testSaveUserWithoutPassword() {
        User user = new User();
        user.setAdmin(false);

        assertThrows(IllegalArgumentException.class, () -> {
            userService.save(user);
        });
    }
}