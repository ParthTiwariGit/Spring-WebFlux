package com.example.reactive_demo.controller;

import com.example.reactive_demo.model.Product;
import com.example.reactive_demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @GetMapping
    public Flux<Product> getAllProducts() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Product> getProductById(@PathVariable String id) {
        return repository.findById(id);
    }

    @PostMapping
    public Mono<String> addProduct(@RequestBody Product product) {
        repository.save(product);
        return Mono.just("Product saved successfully");
    }
}
