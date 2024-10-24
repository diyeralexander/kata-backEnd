package com.dmore.app.springbootcrud.repositories;

import com.dmore.app.springbootcrud.entities.*;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import java.util.Optional;



@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void getAllUsers() {
        List<User> users = userRepository.findAll();
        assertTrue(!users.isEmpty());
    }

    @Test
    public void getUserByName() {
    Optional<User> userName = userRepository.findByUsername("adminKata");
        assertTrue(!userName.isEmpty());
    }
}
