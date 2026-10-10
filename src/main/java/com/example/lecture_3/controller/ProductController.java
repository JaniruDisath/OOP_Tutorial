package com.example.lecture_3.controller;

import com.example.lecture_3.dto.Product;
import com.example.lecture_3.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ResponseBody
@Controller

@RestController

@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping()
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(
            @PathVariable Long id) {
        return productService.getProductById(id)
                .orElse(null); // orElse(null) is a
// placeholder we replace with a real 404 later.
    }

    // continued →
// ...ProductController (continued)
    @PostMapping()
    public Product saveProduct(
            @RequestBody Product product) {
        return productService.addProduct(product);
    }

    @DeleteMapping("/{id}")
    public String deleteProductById(
            @PathVariable Long id) {
        return productService.deleteProduct(id);
    }
}