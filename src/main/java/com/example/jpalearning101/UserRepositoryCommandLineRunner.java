package com.example.jpalearning101;

import java.util.List;
import java.util.Optional;

import com.example.jpalearning101.entity.User;
import com.example.jpalearning101.service.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner {
    

    @Autowired
    private UserRepository userRepository;

    private static final Logger log = LoggerFactory.getLogger(UserDaoServiceCommandLineRunner.class);

    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub
        User user = new User("jill","admin");
        userRepository.save(user);
        log.info("New User is created : " + user);

        Optional<User> userWithIdOne = userRepository.findById(1L);
        log.info("User is retrived : " + userWithIdOne);

        List<User> users = userRepository.findAll();
        log.info("All users : " + users);

    }

}
