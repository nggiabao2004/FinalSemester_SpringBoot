package com.gdu_springboot.springboot_demo.dao;

import com.gdu_springboot.springboot_demo.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ProductDAOImp implements ProductDAO {
    private EntityManager em;
    @Autowired
    public ProductDAOImp(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> query = em.createQuery("from Product", Product.class);
        return query.getResultList();
    }

    @Override
    public Product findById(int id) {
        return em.find(Product.class, id);
    }

    @Override
    @Transactional
    public Product save(Product product) {
        Product saved = em.merge(product);
        return saved;
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Product student = em.find(Product.class, id);
        em.remove(student);
    }
}
