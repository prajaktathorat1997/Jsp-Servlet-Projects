package com.example.PeginationAndSorting.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.PeginationAndSorting.entity.Grade;

public interface GradeRepository extends JpaRepository<Grade, Integer>{

public List<Grade> findByName(String name);

public Grade getByIdAndName(int id, String name);

public List<Grade>  getByIdOrName(int id,String name);

public List<Grade> findByIdGreaterThan(int id);



}