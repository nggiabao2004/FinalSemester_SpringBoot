package com.gdu_springboot.springboot_demo.service;

import com.gdu_springboot.springboot_demo.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(int id);
    Product save(Product product);
    void deleteById(int id);
    public List<Product> getRandomProducts(int limit );
}
