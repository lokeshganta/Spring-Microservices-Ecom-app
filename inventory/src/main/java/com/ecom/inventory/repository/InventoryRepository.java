package com.ecom.inventory.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ecom.inventory.models.Inventory;

public interface InventoryRepository extends MongoRepository<Inventory, String> {
    Optional<Inventory> findByProductId(String productId);
}
