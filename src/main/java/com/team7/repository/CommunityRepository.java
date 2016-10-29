package com.team7.repository;

import com.team7.model.Community;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jbeckman on 10/29/16.
 */
@Repository
public interface CommunityRepository extends PagingAndSortingRepository<Community, String> {
    Community findOneByRegionAndCountry(String region, String country);
}
