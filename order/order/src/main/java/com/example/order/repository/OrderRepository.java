package com.example.order.repository;



import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.order.models.Order;


public interface OrderRepository extends MongoRepository<Order, String> {
}