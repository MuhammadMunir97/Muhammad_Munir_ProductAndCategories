package com.muhammad.products_and_categories.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.muhammad.products_and_categories.modells.CategoryProduct;

@Repository
public interface CategoryProdRepo extends CrudRepository<CategoryProduct, Long>{

}
