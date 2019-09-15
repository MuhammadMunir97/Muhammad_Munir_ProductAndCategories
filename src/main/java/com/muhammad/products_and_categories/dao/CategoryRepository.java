package com.muhammad.products_and_categories.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.muhammad.products_and_categories.modells.Category;
import com.muhammad.products_and_categories.modells.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

	public List<Category> findAll();
	public List<Category> findByProductsNotContains(Product product);
}
