package com.ecom.inventory.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.inventory.models.Inventory;
import com.ecom.inventory.service.InventoryService;

@RestController
@RequestMapping("/inventory")
@CrossOrigin
public class InventoryController {

    @Autowired
    private InventoryService service;

    @GetMapping
    public List<Inventory> getAllInventory() {
        return service.getAllInventory();
    }

    @PostMapping
    public Inventory addInventory(@RequestBody Inventory inventory) {
        return service.addInventory(inventory);
    }

    @PutMapping("/{productId}")
    public Inventory updateStock(@PathVariable String productId, @RequestParam int quantity) {
        return service.updateStock(productId, quantity);
    }

    @PutMapping("/reduce/{productId}")
    public String reduceStock(@PathVariable String productId, @RequestParam int quantity) {
        return service.reduceStock(productId, quantity);
    }

    @GetMapping("/{productId}")
    public int checkStock(@PathVariable String productId) {
        return service.checkStock(productId);
    }

    @DeleteMapping("/{productId}")
    public void deleteInventoryByProductId(@PathVariable String productId) {
        service.deleteInventoryByProductId(productId);
    }

}
