package com.ecom.product.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecom.product.dto.Inventory;

@FeignClient(name = "inventory")
public interface InventoryClient {

    @PostMapping("/inventory")
    void addInventory(@RequestBody Inventory request);

    @DeleteMapping("/inventory/{productId}")
    void deleteInventoryByProductId(@PathVariable("productId") String productId);

    @PutMapping("/inventory/{productId}")
    Inventory updateInventory(@PathVariable("productId") String productId,
                              @RequestParam("quantity") int quantity);


}
