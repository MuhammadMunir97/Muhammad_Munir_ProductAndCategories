package com.muhammad.products_and_categories.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.muhammad.products_and_categories.dao.CategoryProdRepo;
import com.muhammad.products_and_categories.dao.CategoryRepository;
import com.muhammad.products_and_categories.dao.ProductRepository;
import com.muhammad.products_and_categories.modells.Category;
import com.muhammad.products_and_categories.modells.CategoryProduct;
import com.muhammad.products_and_categories.modells.Product;

@Service
public class ProductService {
	
	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;
	private final CategoryProdRepo CategoryProdRepo;
	
	

	public ProductService(ProductRepository productRepository, 
						  CategoryRepository categoryRepository,
						  CategoryProdRepo categoryProdRepo) {
	
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
		CategoryProdRepo = categoryProdRepo;
	}

	public List<Product> findAllProduct(){
		return productRepository.findAll();
	}
	
	public Product findProductById(Long id) {
		Optional<Product> product = productRepository.findById(id);
		if(product.isPresent()) {
			return product.get();
		}else {
			return null;
		}
	}
	
	public List<Category> categoriesNotInProduct(Long id){
		Optional<Product> product = productRepository.findById(id);
		if(product.isPresent()) {
			return categoryRepository.findByProductsNotContains(product.get());
		}else {
			return null;
		}
	}
	
	public void saveCatProd(CategoryProduct categoryProduct) {
		CategoryProdRepo.save(categoryProduct);
	}
	
	public void saveProduct(Product product) {
		productRepository.save(product);
	}
	
	public void deleteProductById(Long id) {
		productRepository.deleteById(id);
	}
	
	public List<Category> findAllCategory(){
		return categoryRepository.findAll();
	}
		
	public Category findCategoryById(Long id) {
		Optional<Category> category = categoryRepository.findById(id);
		if(category.isPresent()) {
			return category.get();
		}else {
			return null;
		}
	}
	
	public List<Product> productNotInCategory(Long id){
		Optional<Category> category = categoryRepository.findById(id);
		if(category.isPresent()) {
			return productRepository.findByCategoriesNotContains(category.get());
		}else {
			return null;
		}
	}
	
	
	public void saveCategory(Category category) {
		categoryRepository.save(category);
	}
	
	public void deleteCategoryById(Long id) {
		categoryRepository.deleteById(id);
	}
}
