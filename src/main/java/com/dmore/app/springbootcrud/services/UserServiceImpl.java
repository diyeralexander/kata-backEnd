package com.dmore.app.springbootcrud.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dmore.app.springbootcrud.entities.Role;
import com.dmore.app.springbootcrud.entities.User;
import com.dmore.app.springbootcrud.repositories.RolReposiroty;
import com.dmore.app.springbootcrud.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolReposiroty rolReposiroty;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
      return  userRepository.findAll();
    }

    @Override
    @Transactional
    public User save(User user) {
        List<Role> roles = new ArrayList<>();
    
        if (Boolean.TRUE.equals(user.getAdmin())) {
            Optional<Role> optionalRoleAdmin = rolReposiroty.findByName("ROLE_ADMIN");
            optionalRoleAdmin.ifPresent(roles::add);
        } else {
            Optional<Role> optionalRoleUser = rolReposiroty.findByName("ROLE_USER");
            optionalRoleUser.ifPresent(roles::add);
        }
    
        user.setRoles(roles);
    
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
    
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    
        return userRepository.save(user);
    }
     
   

}
