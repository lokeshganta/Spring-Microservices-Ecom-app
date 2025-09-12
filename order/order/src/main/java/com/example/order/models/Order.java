package com.example.order.models;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "orders")
public class Order {
    @Id
    private String id;
    private List<OrderItem> items;
    private double totalAmount;
    private LocalDateTime orderDate;
    private String status; // PLACED, SHIPPED, DELIVERED, etc.
}
