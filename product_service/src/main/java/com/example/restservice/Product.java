package com.example.restservice;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Produkts")
public class Product {

    @Id
    private String _id;
    @Field("name")
    private String name;

        public String get_id() {
            return _id;
        }
    
        public String getName() {
            return name;
        }

}
