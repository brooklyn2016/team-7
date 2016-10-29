package com.team7.controller;

import com.team7.model.User;
import com.team7.repository.UserRepository;
import com.team7.security.WebContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sd95 on 10/28/16.
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WebContext webContext;

    @RequestMapping(value="/user", method= RequestMethod.GET)
    public ResponseEntity<User> login() {
        User user = userRepository.findByUsername(webContext.getUsername());

        return new ResponseEntity<>(user,
                HttpStatus.OK);
    }
}
