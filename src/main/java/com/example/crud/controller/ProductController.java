package com.example.crud.controller;

import java.util.List;
import java.util.Optional;

import com.example.crud.model.Product;
import com.example.crud.services.ServiceProduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ServiceProduct serviceProduct;

    @GetMapping("/products")
    public List<Product> getProduct() {
        return serviceProduct.getProducts();
    }

    @GetMapping("/product/{id}")
    public Optional<Product> getMethodName(@PathVariable("id") Integer id) {
        return serviceProduct.getProduct(id);
    }

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return serviceProduct.addProduct(product);
    }

    @PutMapping("/updateProduct/{id}")
    public Product addProduct(@PathVariable("id") Integer id, @RequestBody Product product) {
        return serviceProduct.addProduct(product);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public void deleteproduct(@PathVariable("id") Integer id) {
        serviceProduct.deleteProduct(id);
    }

}