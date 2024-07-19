package com.spring.springmongodb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.springmongodb.dao.PostDao;
import com.spring.springmongodb.dao.SearchRepo;
import com.spring.springmongodb.model.Post;

import springfox.documentation.annotations.ApiIgnore;

@RestController
public class PostController {
	
	@ApiIgnore
	@RequestMapping(value = "/")
	public void redirect(HttpServletResponse response) throws IOException {
		response.sendRedirect("/swagger-ui.html");
	}
	
	@Autowired
	PostDao postdao;
	
	@Autowired
	SearchRepo sRepo;
	
	@GetMapping("/posts")
	public List<Post> getAllPosts(){
		return postdao.findAll();
	}
	
	@GetMapping("/posts/{text}")
	public List<Post> getAllPostsByText(@PathVariable String text){
		return sRepo.findByText(text);
	}
	
	@PostMapping("/post")
	public Post addPost(@RequestBody Post post) {
		return postdao.save(post);
	}
}
