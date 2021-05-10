package com.example.jpalearning101.service;

import com.example.jpalearning101.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

// spring data JPA - just define the intefaces, define repository interfaces

@Component
public interface UserRepository extends JpaRepository<User, Long> {
    
}
