package com.ecom.product.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.product.client.InventoryClient;
import com.ecom.product.dto.Inventory;
import com.ecom.product.models.Product;
import com.ecom.product.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private InventoryClient inventoryClient;

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        // Add product to inventory
        Product savedProduct = productService.saveProduct(product);
        inventoryClient.addInventory(new Inventory(savedProduct.getId(), savedProduct.getQuantity()));
        return productService.saveProduct(savedProduct);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProduct(@PathVariable String id) {
        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable String id, @RequestBody Product new_product) {
        return productService.updateProduct(id,new_product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
        inventoryClient.deleteInventoryByProductId(id);
    }
}
