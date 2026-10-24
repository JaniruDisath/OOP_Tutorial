package com.example.lecture_3.controller;

import com.example.lecture_3.dto.Product;
import com.example.lecture_3.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id).orElse(null);
    }

    @GetMapping("/find/{name}")
    public Optional<Product> findByName(@PathVariable String name){
        System.out.println(name);
        return productService.findByName(name);
    }

    @PostMapping("/add")
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