package edu.zahr.websec.user;

/*
@author ivan
@project IntelliJ IDEA 
@class UserRepository
@version 1.0.0 
@since 14.05.2025 - 21.38
*/

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);
}