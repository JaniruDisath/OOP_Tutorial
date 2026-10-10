package com.example.lecture_3.services;

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

    public List<Product> getAllProducts() {
        products.add(new Product(1L, "Laptop", 999.99));
        return products;
    }

    public Optional<Product> getProductById(
            Long id) {
        return products.stream()
                .filter(p ->
                        p.getId().equals(id))
                .findFirst();
    }

    // continued →
// ...ProductService (continued)
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