package com.team7;

import com.team7.model.Community;
import com.team7.repository.CommunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by sd95 on 10/29/16.
 */
@Component
public class SeedDatabase {
    @Autowired
    CommunityRepository communityRepository;

    @PostConstruct
    public void seedCommunities(){
        Community com1 = communityRepository.save(new Community("Hydrabad", "India", "Village A"));

        for(Community community : communityRepository.findAll()){
            System.out.println("Community " + community);
        }
    }

}
