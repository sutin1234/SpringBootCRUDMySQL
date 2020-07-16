package com.example.crud.services;

import com.example.crud.model.Product;
import com.example.crud.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceProduct {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getProducts() {
        return (List<Product>) productRepository.findAll();
    }

    public Optional<Product> getProduct(Integer id) {
        return productRepository.findById(id);
    }

    public Product addProduct(final Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(final Integer id, final Product product) {
        final Product productOne = productRepository.getOne(id);
        productOne.setProductName(product.getProductName());
        productOne.setProductPrice(product.getProductPrice());
        productOne.setProductQty(product.getProductQty());
        productOne.setProductStatus(product.getProductStatus());
        return productRepository.save(productOne);
    }

    public void deleteProduct(final Integer id) {
       productRepository.deleteById(id);
    }

}