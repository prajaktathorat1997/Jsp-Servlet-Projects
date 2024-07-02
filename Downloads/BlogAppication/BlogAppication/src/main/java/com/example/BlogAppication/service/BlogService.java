package com.example.BlogAppication.service;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BlogAppication.entity.Blog;
import com.example.BlogAppication.repository.BlogRepository;

@Service
public class BlogService {
@Autowired
BlogRepository repo;
	public String save(Blog blog) {
		 return repo.save(blog);
		
	}
	@Transactional
	public Map<String, Blog> update(Blog blog, int id) {
		return repo.update(blog,id);
		
	}
	public String delete(int id) {
		return repo.delete(id);
		
	}
	public List<Blog> getAll() {
		return repo.getAll();
		
	}

}
