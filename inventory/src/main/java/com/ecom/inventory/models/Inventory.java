package com.ecom.inventory.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "inventory")
public class Inventory {
    @Id
    private String productId;
    private int quantity;

}
