package com.dmore.app.springbootcrud.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmore.app.springbootcrud.entities.Role;
import com.dmore.app.springbootcrud.entities.User;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolReposiroty roleRepository;

    @GetMapping("/test/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/test/roles")
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}