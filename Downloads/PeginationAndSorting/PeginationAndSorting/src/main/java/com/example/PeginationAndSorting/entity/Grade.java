package com.example.PeginationAndSorting.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Grade {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
private String name;
private String dept;
public int getId() {
	return id;
}
public Grade() {
	super();
	// TODO Auto-generated constructor stub
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDept() {
	return dept;
}
public void setDept(String dept) {
	this.dept = dept;
}
@Override
public String toString() {
	return "Grade [id=" + id + ", name=" + name + ", dept=" + dept + "]";
}
public Grade(int id, String name, String dept) {
	super();
	this.id = id;
	this.name = name;
	this.dept = dept;
}

}
