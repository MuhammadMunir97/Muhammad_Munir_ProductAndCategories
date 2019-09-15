package com.muhammad.products_and_categories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.muhammad.products_and_categories.modells.Category;
import com.muhammad.products_and_categories.modells.CategoryProduct;
import com.muhammad.products_and_categories.modells.Product;
import com.muhammad.products_and_categories.service.ProductService;



@Controller
public class CategoryController {

	private final ProductService productService;

	public CategoryController(ProductService productService ) {
		this.productService = productService;
	}

	@RequestMapping("/category")
	public String allCategories(Model model) {
		List<Category> categories = productService.findAllCategory();
		model.addAttribute("categories" , categories);
		return "/view/Category.jsp";
	}
	
	@RequestMapping("/category/new")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "/view/CategoryForm.jsp";
	}
	
	@RequestMapping(value="/category" ,  method=RequestMethod.POST)
	public String addCategory(@Valid @ModelAttribute("category") Category category , BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "redirect:/category";
		}else {
			productService.saveCategory(category);
			return "redirect:/category";
		}
	}
	
	@RequestMapping("/category/{categoryId}")
	public String addProduct(@PathVariable("categoryId") Long id , Model model, @ModelAttribute("categoryProduct") CategoryProduct categoryProduct) {
		List<Product> productToAdd = productService.productNotInCategory(id);
		Category category = productService.findCategoryById(id);
		categoryProduct.setCategory(category);
		model.addAttribute("products" , productToAdd);
		return "/view/AddProductToCategory.jsp";
	}
	
	@RequestMapping(value="/category/{categoryId}", method=RequestMethod.POST)
	 public String update(@Valid @ModelAttribute("categoryProduct") CategoryProduct categoryProduct, BindingResult bindingResult, @PathVariable("categoryId") Long id ) {
		 if(bindingResult.hasErrors()) {
			return "redirect:/category";
		}else {
			Category category = productService.findCategoryById(id);
			categoryProduct.setCategory(category);
			productService.saveCatProd(categoryProduct);
			return "redirect:/category";
		}
	 }
	
	@RequestMapping(value="/category/{id}" , method=RequestMethod.DELETE)
	public String deleteCategory(@PathVariable("id") Long id) {
		productService.deleteCategoryById(id);
		return "redirect:/category";
	}
	

	
}
