package com.team7.controller;

import com.team7.model.Community;
import com.team7.repository.CommunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jbeckman on 10/29/16.
 */
@RestController
public class CommunityController {

    @Autowired
    private CommunityRepository communityRepository;

    @RequestMapping(value = "/community", method = RequestMethod.GET)
    public Community getCommunity(@RequestHeader(value = "region", required = false) String region,
                                  @RequestHeader(value = "country", required = false) String country) {

        return communityRepository.findOneByRegionAndCountry(region, country);
    }

    @RequestMapping(value = "/community", method = RequestMethod.POST)
    public ResponseEntity<Community> setCommunity(@RequestHeader(value = "region", required = false) String region,
                                                  @RequestHeader(value = "country", required = false) String country) {

        Community community = communityRepository.save(new Community(region, country));

        if(community == null) {
            return new ResponseEntity<Community>((Community)null, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<Community>(community, HttpStatus.CREATED);
        }

    }
}
