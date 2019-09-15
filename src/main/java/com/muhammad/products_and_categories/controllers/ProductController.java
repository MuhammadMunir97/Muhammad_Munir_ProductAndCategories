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
public class ProductController {

	private final ProductService productService;


	public ProductController(ProductService productService ) {
		this.productService = productService;
	}
	
	@RequestMapping("/product")
	public String allProducts(Model model) {
		List<Product> allProducts = productService.findAllProduct();
		model.addAttribute("products", allProducts);
		return "/view/Product.jsp";
	}
	
	@RequestMapping("/product/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "/view/ProductForm.jsp";
	}
	
	@RequestMapping(value="/product" ,  method=RequestMethod.POST)
	public String addProduct(@Valid @ModelAttribute("product") Product product , BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "redirect:/product";
		}else {
			productService.saveProduct(product);
			return "redirect:/product";
		}
	}
	
	@RequestMapping("/product/{productId}")
	public String addCategory(@PathVariable("productId") Long id , Model model, @ModelAttribute("categoryProduct") CategoryProduct categoryProduct) {
		List<Category> categoriesToAdd = productService.categoriesNotInProduct(id);
		Product product = productService.findProductById(id);
		model.addAttribute("product", product);
		model.addAttribute("categories" , categoriesToAdd);
		return "/view/AddCategoryToProduct.jsp";
	}
	
	 @RequestMapping(value="/product/{productId}", method=RequestMethod.POST)
	 public String update(@Valid @ModelAttribute("categoryProduct") CategoryProduct categoryProduct, BindingResult bindingResult, @PathVariable("productId") Long id ) {
		 if(bindingResult.hasErrors()) {
			return "redirect:/product";
		}else {
			Product product = productService.findProductById(id);
			categoryProduct.setProduct(product);
			productService.saveCatProd(categoryProduct);
			return "redirect:/product";
		}
	 }
	
	@RequestMapping(value="/product/{id}" , method=RequestMethod.DELETE)
	public String deleteProduct(@PathVariable("id") Long id) {
		productService.deleteProductById(id);
		return "redirect:/product";
	}
}
