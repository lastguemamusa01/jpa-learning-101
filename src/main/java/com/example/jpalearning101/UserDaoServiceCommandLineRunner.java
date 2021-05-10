package com.example.jpalearning101;

import com.example.jpalearning101.entity.User;
import com.example.jpalearning101.service.UserDAOService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserDaoServiceCommandLineRunner implements CommandLineRunner {

    @Autowired
    private UserDAOService userDAOService;

    private static final Logger log = LoggerFactory.getLogger(UserDaoServiceCommandLineRunner.class);

    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub
        User user = new User("jack","admin");
        long insert = userDAOService.insert(user);
        log.info("New User is created : " + user);
    }
    
}
