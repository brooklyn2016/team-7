package com.team7;

import com.team7.model.User;
import com.team7.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by sd95 on 10/29/16.
 */
@Component
public class sampledb {

    private final Logger logger = LoggerFactory.getLogger(sampledb.class);

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void listUsers(){
        logger.debug("Database Users");
        logger.debug("===============");
        for (User user : userRepository.findAll()) {
            logger.debug(">>>>> {}", user);
        }
    }
}
