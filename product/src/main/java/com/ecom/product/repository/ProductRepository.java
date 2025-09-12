package com.ecom.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ecom.product.models.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
}
