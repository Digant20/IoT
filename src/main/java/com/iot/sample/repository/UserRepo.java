package com.iot.sample.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.iot.sample.model.User;



@Repository
public interface UserRepo extends MongoRepository<User, String> {

	//Optional<User> findByUserId(String id);

	

	
	
}
