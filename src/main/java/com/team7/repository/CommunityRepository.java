package com.team7.repository;

import com.team7.model.Community;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jbeckman on 10/29/16.
 */
@Repository
public interface CommunityRepository extends PagingAndSortingRepository<Community, String> {
    public Community findOneByNameAndCountry(String name, String country);

    @Query("select c from Community c where LOWER(TRIM(c.name)) like %:queryString% OR LOWER(TRIM(c.country)) like %:queryString% OR LOWER(TRIM(c.region)) like %:queryString%")
    public List<Community> findByQuery(@Param("queryString") String queryString);
}
