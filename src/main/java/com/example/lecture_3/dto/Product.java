package com.example.lecture_3.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION)
@JsonSubTypes({
        @JsonSubTypes.Type(DigitalProduct.class),
        @JsonSubTypes.Type(PhysicalProduct.class)
})

public class Product {
    private Long id;
    private String name;
    private Double price;


    public Product() {
    } // required by Jackson

    public Product(Long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(Double price) {
        if (price < 0) throw new IllegalArgumentException("Price cannot be less than 0");
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }
}