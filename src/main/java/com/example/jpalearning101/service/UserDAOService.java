package com.example.jpalearning101.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.example.jpalearning101.entity.User;

import org.springframework.stereotype.Repository;

// repository is something that interact with the database
@Repository
@Transactional
public class UserDAOService {

    // to save data in db
    @PersistenceContext
    private EntityManager entityManager; 
    
    public long insert(User user) {
        // open Transaction
        entityManager.persist(user);
        // cloase transaction
        return user.getId();
    }
}

