package com.team7.repository;

import com.team7.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sd95 on 10/28/16.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    User findByUsername(String username);
}
