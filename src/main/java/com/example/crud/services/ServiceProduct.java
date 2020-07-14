package com.example.crud.services;

import com.example.crud.model.Product;
import java.util.List;
import java.util.Optional;

import com.example.crud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceProduct {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(final Integer id) {
        return productRepository.getOne(id);
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