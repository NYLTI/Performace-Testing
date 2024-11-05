package com.service.impl;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Product;
import com.repository.ProductRepository;
import com.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repository;

	@Override
	public List<Product> getAllProducts() {
		return repository.findAll();
	}

	@Override
	public Product getProductById(ObjectId id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public Product createProduct(Product product) {
		return repository.save(product);
	}

	@Override
	public Product updateProduct(ObjectId id, Product productDetails) {
		Product product = repository.findById(id).orElse(null);
		if (product != null) {
			product.setName(productDetails.getName());
			product.setPrice(productDetails.getPrice());
			return repository.save(product);
		}
		return null;
	}

	@Override
	public void deleteProduct(ObjectId id) {
		repository.deleteById(id);
	}
}
