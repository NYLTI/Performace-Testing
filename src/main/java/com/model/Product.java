package com.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "product")
@Data
public class Product {

    @Id
    private ObjectId id;
    private String name;
    private double price;
}
