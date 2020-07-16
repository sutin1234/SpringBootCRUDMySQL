package com.example.crud.repository;

import com.example.crud.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product getOne(Integer id);
}