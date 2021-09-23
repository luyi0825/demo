package com.test.mongo;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author luyi
 */
public interface UserDao extends MongoRepository<User,String> {

    User findByUserName(String userName);
}
