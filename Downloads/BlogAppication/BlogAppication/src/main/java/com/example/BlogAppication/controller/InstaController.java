package com.example.BlogAppication.controller;

import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.BlogAppication.entity.Instagram;
import com.example.BlogAppication.service.InstaService;

@RestController
@RequestMapping("/insta")
public class InstaController {
@Autowired
InstaService service;
@PostMapping("save")
public ResponseEntity<Instagram> save(@RequestBody Instagram insta) {
	Instagram instagram = service.save(insta);
	return ResponseEntity.status(HttpStatus.CREATED).body(instagram);
}

@PutMapping("update/{id}")
public ResponseEntity<Map<Instagram, String>> update(@RequestBody Instagram insta,@PathVariable long id) {
	Map<Instagram, String> update = service.update(insta,id);
	return ResponseEntity.ok(update);
}
@GetMapping("getAll")
public ResponseEntity<List<Instagram>> getAll() {
	List<Instagram> all = service.getAll();
	return ResponseEntity.ok(all);
}
@DeleteMapping("delete/{id}")
public ResponseEntity<String> delete(@PathVariable Long id) {
	String delete = service.delete(id);
	return ResponseEntity.ok(delete);
}

}
