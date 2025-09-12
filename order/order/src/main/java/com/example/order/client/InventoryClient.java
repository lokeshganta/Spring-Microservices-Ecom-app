package com.example.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "inventory")
public interface InventoryClient {

    @GetMapping("/inventory/{productId}")
    int checkStock(@PathVariable("productId") String productId);

    @PutMapping("/inventory/reduce/{productId}")
    String reduceInventory(@PathVariable("productId") String productId,
                              @RequestParam("quantity") int quantity);


}
