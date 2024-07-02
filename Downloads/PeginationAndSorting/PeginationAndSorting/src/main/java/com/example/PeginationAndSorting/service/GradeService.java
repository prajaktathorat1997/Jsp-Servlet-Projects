package com.example.PeginationAndSorting.service;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.PeginationAndSorting.entity.Grade;
import com.example.PeginationAndSorting.repository.GradeRepository;

@Service
public class GradeService {
@Autowired
GradeRepository repo;

public Grade save(Grade grade) {
	Grade grd = repo.save(grade);
	return grd;
}

public List<Grade> getByName(String name) {
	return repo.findByName(name);
	
}

public Grade get(int id) {
	Grade grade = repo.findById(id).get();
	return grade;
}

public Grade getByIdAndName(int id, String name) {
	return repo.getByIdAndName(id,name);

}

public List<Grade>  getByIdOrName(int id,String name) {
	
	return repo.getByIdOrName(id ,name);
}

public List<Grade> findByIdGreaterThan(int id) {
	// TODO Auto-generated method stub
	return repo.findByIdGreaterThan(id);
}

public List<Grade> findAll(int pageNumber,int pageSize,String field) {
	 PageRequest withSort = PageRequest.of(pageNumber, pageSize).withSort(Direction.ASC, field);
	
	 Page<Grade> all = repo.findAll(withSort);
	return all.getContent();
}


}
