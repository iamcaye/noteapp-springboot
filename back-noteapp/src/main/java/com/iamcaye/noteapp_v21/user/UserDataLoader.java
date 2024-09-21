package com.iamcaye.noteapp_v21.user;

import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserDataLoader implements  CommandLineRunner {
    private final UserRepository userRepository;
    private final Logger logger = org.slf4j.LoggerFactory.getLogger(UserDataLoader.class);

    public UserDataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {
        if(this.userRepository.count() > 0) {
            logger.info("Users already loaded");
        } else {
            logger.info("Loading users...");
            for (int i = 1; i <= 10; i++) {
                userRepository.save(new User(null, "user" + i, "user" + i + "@example.com"));
            }
        }
    }
}
