package com.example.ProductCategory.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProductCategory.entity.Category;
import com.example.ProductCategory.entity.Product;
import com.example.ProductCategory.entity.Ratings;
import com.example.ProductCategory.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	public ProductController() {
		
	}
@Autowired
private	ProductService service;
@PostMapping("/save")
public ResponseEntity<Product> save(@RequestBody Product product) {
	Product save = service.save(product);
return ResponseEntity.of(Optional.of(save));
}
@PutMapping("update/{id}")
public ResponseEntity<Product> update(@RequestBody Product product,@PathVariable long id) {
	Product update = service.update(product, id);
	return ResponseEntity.ok(update);
}
@GetMapping("getAll")
public ResponseEntity<List<Product>> getAll(@RequestParam(value="pageNumber", defaultValue = "0",required = false)int pageNumber,
		@RequestParam(value="pageSize", defaultValue = "3",required = false)int pageSize,
		@RequestParam("field")String field) {
	List<Product> all = service.getAll(pageNumber, pageSize,field);
	return ResponseEntity.ok(all);
}
@DeleteMapping("delete/{id}")
public String delete(@PathVariable long id) {
	String msg=service. delete(id);
	return msg;
}



@GetMapping("getByName/{name}")
public ResponseEntity<List<Product>> findByName(@PathVariable String name) {
	List<Product> byName = service.findByName(name);
	return ResponseEntity.of(Optional.of(byName));
}
@GetMapping("getByCategory/{category}")
public ResponseEntity<List<Product>> findByCategory(@PathVariable Category category) {
	List<Product> byName = service.findByCategory(category);
	return ResponseEntity.of(Optional.of(byName));
}
@GetMapping("/getByAttribute")
public ResponseEntity<List<Product>> findByAttribute(@RequestParam("key") String key, @RequestParam("value") String value) {
    List<Product> products = service.findByAttribute(key, value);
    return ResponseEntity.of(Optional.of(products));
}
@PutMapping("rate/{productId}")
public ResponseEntity<Product> updateRating(@PathVariable long productId,@RequestBody Ratings ratings) {
	Product value=service.updateRating(productId,ratings);
	return ResponseEntity.of(Optional.of(value));
}




















































}
