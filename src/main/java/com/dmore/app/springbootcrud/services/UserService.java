package com.dmore.app.springbootcrud.services;

import java.util.List;

import com.dmore.app.springbootcrud.entities.User;

public interface UserService {
    List<User> findAll();
    User save(User user);


}
