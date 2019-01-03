package com.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.app.entity.models.UserModel;

public interface UserRepository extends MongoRepository<UserModel, String>, QueryDslPredicateExecutor<UserModel> {
	UserModel findByUsername(String username);
}
