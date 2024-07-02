package com.example.ProductCategory.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private long id;
	private String name;
	private String description;
	private double price;
	
	@ElementCollection
	@Enumerated(EnumType.STRING)
	@CollectionTable(name="product_category")
	private List<Category> categories;
	
	@ElementCollection
	@CollectionTable(name="product_attributes")
	@MapKeyColumn(name="attribute_name")
	@Column(name="attribute_value")
	private Map<String,String> attributes;
	
	
	@Embedded
	private Avaibility availibility;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="product_id")
	private List<Ratings> ratings;
	public Product() {
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	public Map<String, String> getAttributes() {
		return attributes;
	}
	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}
	public Avaibility getAvailibility() {
		return availibility;
	}
	public void setAvailibility(Avaibility availibility) {
		this.availibility = availibility;
	}
	public List<Ratings> getRatings() {
		return ratings;
	}
	public void setRatings(List<Ratings> ratings) {
		this.ratings = ratings;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", categories=" + categories + ", attributes=" + attributes + ", availibility=" + availibility
				+ ", ratings=" + ratings + "]";
	}
	public Product(long id, String name, String description, double price, List<Category> categories,
			Map<String, String> attributes, Avaibility availibility, List<Ratings> ratings) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.categories = categories;
		this.attributes = attributes;
		this.availibility = availibility;
		this.ratings = ratings;
	}

}
