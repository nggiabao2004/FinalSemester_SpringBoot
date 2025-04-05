package com.gdu_springboot.springboot_demo.dao;

import com.gdu_springboot.springboot_demo.entity.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> findAll();
    Product findById(int id);
    Product save(Product product);
    void deleteById(int id);
}
