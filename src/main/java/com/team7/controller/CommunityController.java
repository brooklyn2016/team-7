package com.team7.controller;

import com.team7.model.Community;
import com.team7.repository.CommunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jbeckman on 10/29/16.
 */
@RestController
public class CommunityController {

    @Autowired
    private CommunityRepository communityRepository;

    @RequestMapping(value = "/community", method = RequestMethod.GET)
    public ResponseEntity<Community> getCommunity(@RequestHeader(value = "country") String country,
                                  @RequestHeader(value = "name") String name) {

        Community community = communityRepository.findOneByNameAndCountry(name, country);

        if(community == null) {
            return new ResponseEntity<Community>((Community)null, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<Community>(community, HttpStatus.CREATED);
        }
    }

    @RequestMapping(value = "/community", method = RequestMethod.POST)
    public ResponseEntity<Community> setCommunity(@RequestHeader(value = "region", required = false) String region,
                                                  @RequestHeader(value = "country") String country,
                                                  @RequestHeader(value = "name") String name) {

        Community community = communityRepository.save(new Community(region, country, name));

        if(community == null) {
            return new ResponseEntity<Community>((Community)null, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<Community>(community, HttpStatus.CREATED);
        }

    }

    @RequestMapping(value = "/community?queryFor={queryString}", method = RequestMethod.GET)
    public ResponseEntity<List<Community>> queryCommunity(@PathVariable("queryString") String queryString) {

        List<Community> communities = communityRepository.findByQuery(queryString);

        if(communities.size() == 0) {
            return new ResponseEntity<>((List<Community>)null, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(communities, HttpStatus.CREATED);
        }

    }
}
