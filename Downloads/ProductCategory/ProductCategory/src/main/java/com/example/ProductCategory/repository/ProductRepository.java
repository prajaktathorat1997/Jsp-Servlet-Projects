package com.example.ProductCategory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ProductCategory.entity.Category;
import com.example.ProductCategory.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findByName(String name);

	

	List<Product> findByCategories(Category category);

	@Query(value = "SELECT DISTINCT p.*  FROM Product p JOIN product_attributes a ON p.id = a.product_id  WHERE a.attribute_name = :key AND a.attribute_value = :value", nativeQuery = true)
	List<Product> findByAttributes(@Param("key") String key, @Param("value") String value);

	

}
