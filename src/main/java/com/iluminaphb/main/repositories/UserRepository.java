package com.iluminaphb.main.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.iluminaphb.main.models.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    
}
