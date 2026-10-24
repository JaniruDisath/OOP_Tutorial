package com.example.lecture_3.services;

import com.example.lecture_3.dto.PhysicalProduct;
import com.example.lecture_3.dto.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private List<Product> products
            = new ArrayList<>();
    private Long nextId = 1L;

    public ProductService(){
        addProducts();
    }

    private void addProducts(){
        products.add(new Product(1L, "Laptop", 999.99));
        products.add(new PhysicalProduct(1L, "Laptop", 999.99, 10.0, "Hello"));
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Optional<Product> getProductById(
            Long id) {
        return products.stream()
                .filter(p ->
                        p.getId().equals(id))
                .findFirst();
    }

    public Optional<Product> findByName(String name){
        return products.stream().filter(p-> p.getName().equals(name)).findFirst();
    }

    public Product addProduct(
            Product product) {
        product.setId(nextId);
        nextId += 1L;
        products.add(product);
        return product;
    }

    public String deleteProduct(Long id) {
        boolean isDeleted =
                products.removeIf(p ->
                        p.getId().equals(id));
        if (isDeleted) {
            return "Deleted successfully";
        } else {
            return "ID not found";
        }
    }
}