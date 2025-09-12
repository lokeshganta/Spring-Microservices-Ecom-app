package com.example.Auth.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("users")
public class User {
    @Id
    private String id;
    private String username;
    private String email;
    private String password;
}