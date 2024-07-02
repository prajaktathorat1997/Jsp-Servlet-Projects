package com.example.BlogAppication.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BlogAppication.entity.Blog;
import com.example.BlogAppication.service.BlogService;

@RestController
@RequestMapping("/blog")
public class BlogController {
@Autowired
	BlogService service;

	@PostMapping("save")
public ResponseEntity<String> save(@RequestBody Blog blog) {
	String msg=service.save(blog);
	return ResponseEntity.status(HttpStatus.CREATED).body(msg);
}
@PutMapping("update/{id}")
	public ResponseEntity<Map<String, Blog>> update(@RequestBody Blog blog,@PathVariable int id) {
		Map<String, Blog> map=service.update(blog,id);
		return ResponseEntity.of(Optional.of(map));
	}
	@DeleteMapping("delete/{id}")
public ResponseEntity<String> delete(@PathVariable int id) {
	String msg=service.delete(id);
	return ResponseEntity.of(Optional.of(msg));
}
	@GetMapping("getAll")
	public ResponseEntity<List<Blog>> getAll() {
		List<Blog> list=service.getAll();
		return ResponseEntity.ok().header("getAll", "Blogs").body(list);
	}
	
	

}
