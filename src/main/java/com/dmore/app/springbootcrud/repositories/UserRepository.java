package com.dmore.app.springbootcrud.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dmore.app.springbootcrud.entities.User;


public interface UserRepository extends JpaRepository<User, Long>{

    Optional<User> findByUsername(String username);

}
