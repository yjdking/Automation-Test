package com.cmb.service;

import com.cmb.entity.Product;
import com.cmb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Optional<Product> find(String productId) {
		return productRepository.findById(productId);
	}
}
