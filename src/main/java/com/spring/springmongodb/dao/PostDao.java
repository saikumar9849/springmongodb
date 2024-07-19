package com.spring.springmongodb.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.spring.springmongodb.model.Post;

@Repository
public interface PostDao extends MongoRepository<Post, String>{
	
}
