package com.example.ProductCategory.service;




import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.ProductCategory.entity.Category;
import com.example.ProductCategory.entity.Product;
import com.example.ProductCategory.entity.Ratings;
import com.example.ProductCategory.repository.ProductRepository;
@Service
public class ProductService {

	public ProductService() {
		
	}
@Autowired
private ProductRepository repo;

	public Product save(Product product) {
		Product save = repo.save(product);
		return save;
	}

	public Product update(Product product, long id) {
		Product product1 = repo.getById(id);
		product1.setName(product.getName());
		product1.setPrice(product.getPrice());
		product1.setRatings(product.getRatings());
		product1.setDescription(product.getDescription());
		product1.setCategories(product.getCategories());
		product1.setAvailibility(product.getAvailibility());
		product1.setAttributes(product.getAttributes());
		Product save = repo.save(product1);
		return save;
	}

	public List<Product> getAll(int pageNumber,int pageSize,String field) {
		Page<Product> all = repo.findAll(PageRequest.of( pageNumber, pageSize).withSort(Direction.DESC, field));
		List<Product> content = all.getContent();
		return content;
	}

	public List<Product> findByName(String name) {
		
		List<Product> list=repo.findByName(name);
		return list;
	}

	public List<Product> findByCategory(Category category) {
		List<Product> list=repo.findByCategories(category);
		return list;
	}

	public List<Product> findByAttribute(String key, String value) {
		List<Product> list=repo.findByAttributes(key,value);
		return list;
	}

	public String delete(long id) {
		Product p=repo.getById(id);
		repo.delete(p);
		return "deleted........";
	}

	public Product updateRating(long productId, Ratings ratings) {
		Product product=repo.getById(productId);
		 product.getRatings().add(new Ratings( ratings.getUserId(),ratings.getRating(), ratings.getComment()));
	return repo.save(product);
	
	
	
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
