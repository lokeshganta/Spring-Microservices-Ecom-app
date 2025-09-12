package com.example.order.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.order.client.InventoryClient;
import com.example.order.models.Order;
import com.example.order.models.OrderItem;
import com.example.order.repository.OrderRepository;



@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private InventoryClient inventoryClient;

    public Order placeOrder(Order order) {
        double totalAmount = 0.0;

        // Check inventory for all items
        for (OrderItem item : order.getItems()) {
            String productId = item.getProductId();
            int quantity = item.getQuantity();

            int availableStock = inventoryClient.checkStock(productId);
            if (availableStock < quantity) {
                return null;
                // throw new RuntimeException("Insufficient stock for product: " + productId);
            }
        }

        // If all items have sufficient stock, reduce inventory and calculate total
        for (OrderItem item : order.getItems()) {
            inventoryClient.reduceInventory(item.getProductId(), item.getQuantity());
            totalAmount += item.getPrice() * item.getQuantity();
        }

        // Save order
        order.setOrderDate(LocalDateTime.now());
        order.setStatus("PLACED");
        order.setTotalAmount(totalAmount);

        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(String id) {
        return orderRepository.findById(id);
    }

    public boolean deleteOrderById(String id) {

        if (orderRepository.existsById(id)) {
            return orderRepository.findById(id).map(order -> {
                orderRepository.delete(order);
                return true;
            }).orElse(false);
        }
        return false;

    }
}
