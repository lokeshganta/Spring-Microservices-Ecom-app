package com.ecom.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.product.client.InventoryClient;
import com.ecom.product.models.Product;
import com.ecom.product.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private InventoryClient inventoryClient;

    // Create or update product
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    // Get all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Get product by ID
    public Optional<Product> getProductById(String id) {
        return productRepository.findById(id);
    }

    // Delete product
    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }

    public Product updateProduct(String id, Product newProduct) {
    Product existingProduct = productRepository.findById(id).orElse(null);
    if (existingProduct == null) {
        return null;
    }

    existingProduct.setName(newProduct.getName());
    existingProduct.setDescription(newProduct.getDescription());
    existingProduct.setPrice(newProduct.getPrice());
    existingProduct.setQuantity(newProduct.getQuantity());
    existingProduct.setCategory(newProduct.getCategory());
    existingProduct.setImages(newProduct.getImages());
    Product saved= productRepository.save(existingProduct);

    inventoryClient.updateInventory(saved.getId(), saved.getQuantity());

    return saved;
}

}
