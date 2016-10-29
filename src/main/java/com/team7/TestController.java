package com.team7;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sd95 on 10/28/16.
 */

@Component
@RestController
public class TestController {


    @RequestMapping(value="/test", method= RequestMethod.GET)
    ResponseEntity<String> testMessage(){
        return new ResponseEntity<String>("Hello World", HttpStatus.OK);
    }

}
