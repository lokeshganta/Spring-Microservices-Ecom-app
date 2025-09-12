package com.ecom.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.inventory.models.Inventory;
import com.ecom.inventory.repository.InventoryRepository;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository repository;

    public Inventory addInventory(Inventory inventory) {
        return repository.save(inventory);
    }

    public Inventory updateStock(String productId, int quantity) {
        Inventory inventory = repository.findByProductId(productId).orElse(null);
        if (inventory != null) {
            inventory.setQuantity(quantity);
            return repository.save(inventory);
        }
        return null;
    }

    public int checkStock(String productId) {
        return repository.findByProductId(productId).map(Inventory::getQuantity).orElse(0);
    }

    public boolean deleteInventoryByProductId(String productId) {
        if (repository.existsById(productId)) {
            repository.deleteById(productId);
            return true;
        }
        return false;
    }

    public String reduceStock(String productId, int quantityToDeduct) {
        Inventory inventory = repository.findByProductId(productId).orElse(null);
        if (inventory == null) {
            return "Failed:Product not found";
        }

        if (inventory != null && inventory.getQuantity() >= quantityToDeduct) {
            inventory.setQuantity(inventory.getQuantity() - quantityToDeduct);
            repository.save(inventory);
            return "Success:Stock reduced successfully";
        }

        return "Failed:Insufficient stock";
    }

    public List<Inventory> getAllInventory() {
        return repository.findAll();
    }
}
