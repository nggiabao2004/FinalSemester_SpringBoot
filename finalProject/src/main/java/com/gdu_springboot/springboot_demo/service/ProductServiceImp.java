package com.gdu_springboot.springboot_demo.service;

import com.gdu_springboot.springboot_demo.dao.ProductDAO;
import com.gdu_springboot.springboot_demo.entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImp implements ProductService {
    private ProductDAO productDAO;
    @Autowired
    public ProductServiceImp(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public Product findById(int id) {
        return productDAO.findById(id);
    }

    @Override
    public Product save(Product product) {return productDAO.save(product);}

    @Override
    @Transactional
    public void deleteById(int id) {
        productDAO.deleteById(id);
    }

    @Override
    public List<Product> getRandomProducts(int limit ){
        List<Product> allProducts = productDAO.findAll();
        Collections.shuffle(allProducts); // Trộn ngẫu nhiên danh sách
        return allProducts.stream().limit(limit).collect(Collectors.toList());
    }
}
