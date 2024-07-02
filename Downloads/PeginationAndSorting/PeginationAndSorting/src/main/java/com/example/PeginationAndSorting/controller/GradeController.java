package com.example.PeginationAndSorting.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.PeginationAndSorting.entity.Grade;
import com.example.PeginationAndSorting.service.GradeService;

@RestController
@RequestMapping("/grade")
public class GradeController {
@Autowired
GradeService service;
@PostMapping("save")
public ResponseEntity<Grade> save(@RequestBody Grade grade) {
	Grade grade2 = service.save(grade);
	return ResponseEntity.of(Optional.of(grade2));
}
@GetMapping("getByName")	
public ResponseEntity<List<Grade>> getByName(@RequestParam("name") String name) {
	List<Grade> byName = service.getByName(name);
	return ResponseEntity.of(Optional.of(byName));
}
@GetMapping("get/{id}")	
public Grade get(@PathVariable int id) {
	Grade grade = service.get(id);
	return grade;
}	
@GetMapping("getByIdAndName")	
public Grade getByIdAndName(@RequestParam("id") int id,@RequestParam("name") String name) {
	Grade grade = service.getByIdAndName(id,name);
	return grade;
}	

@GetMapping("getByIdOrName")	
public List<Grade> getByIdOrName(@RequestParam("id") int id,@RequestParam("name") String name) {
	List<Grade>  grade = service.getByIdOrName(id,name);
	return grade;
}	
@GetMapping("findByIdGreaterThan")	
public List<Grade> findByIdGreaterThan(@RequestParam("id") int id) {
	List<Grade>  grade = service.findByIdGreaterThan(id);
	return grade;
}	

@GetMapping("getAll")	
public List<Grade> findAll(@RequestParam(value="pageNumber",defaultValue ="0",required = false) int pageNumber,
		@RequestParam(value="pageSize",defaultValue ="3",required = false) int pageSize,
		@RequestParam("field") String field) {
	List<Grade>  grade = service.findAll(pageNumber,pageSize,field);
	return grade;
}	























	
}
