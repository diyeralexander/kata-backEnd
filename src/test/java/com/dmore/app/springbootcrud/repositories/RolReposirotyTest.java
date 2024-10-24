package com.dmore.app.springbootcrud.repositories;


import com.dmore.app.springbootcrud.entities.Task;
import com.dmore.app.springbootcrud.entities.User;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.dmore.app.springbootcrud.entities.Role;

@DataJpaTest
public class RolReposirotyTest {

    @Autowired
    private RolReposiroty rolRepository;

    @Test
    public void getAllRoles() {
        List<Role> tasks = rolRepository.findAll();
        assertTrue(!tasks.isEmpty());
    }

    @Test
    public void getTaskByName() {
        Optional<Role> taskName = rolRepository.findByName("ROLE_ADMIN");
        assertTrue(!taskName.isEmpty());
    }



}
