package com.spring.springmongodb.dao;

import java.util.List;

import com.spring.springmongodb.model.Post;

public interface SearchRepo {
	public List<Post> findByText(String text);
}
