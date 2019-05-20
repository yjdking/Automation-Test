package com.cmb.controller;

import com.cmb.entity.Product;
import com.cmb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/{id}")
	public Product get(@PathVariable String id) {
		final Optional<Product> product = productService.find(id);
		if (product.isPresent()) {
			return product.get();
		} else {
			throw new IllegalArgumentException("product doesn't exist");
		}
	}
}
