package com.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.model.Product;

public interface ProductService {
	List<Product> getAllProducts();
    Product getProductById(ObjectId id);
    Product createProduct(Product product);
    Product updateProduct(ObjectId id, Product productDetails);
    void deleteProduct(ObjectId id);
}
