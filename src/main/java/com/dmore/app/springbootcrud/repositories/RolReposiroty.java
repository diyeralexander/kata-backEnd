package com.dmore.app.springbootcrud.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dmore.app.springbootcrud.entities.Role;

public interface RolReposiroty extends JpaRepository<Role, Long>{

    Optional<Role> findByName(String name);

}
