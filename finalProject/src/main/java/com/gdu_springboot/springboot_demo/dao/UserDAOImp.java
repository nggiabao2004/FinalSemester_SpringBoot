package com.gdu_springboot.springboot_demo.dao;

import com.gdu_springboot.springboot_demo.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImp implements UserDAO {
    private final EntityManager entityManager;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserDAOImp(EntityManager entityManager, PasswordEncoder passwordEncoder) {
        this.entityManager = entityManager;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> findAll() {
        TypedQuery<User> query = entityManager.createQuery("FROM User", User.class);
        return query.getResultList();
    }

    @Override
    public User findByUsername(String username) {
        return entityManager.find(User.class, username);
    }

    @Override
    @Transactional
    public User save(User user) {
        User existingUser = entityManager.find(User.class, user.getUsername());

        if (existingUser != null) {
            existingUser.setEnabled(user.isEnabled());
            return entityManager.merge(existingUser);
        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return entityManager.merge(user);
        }
    }

    @Override
    @Transactional
    public void deleteByUsername(String username) {
        User user = entityManager.find(User.class, username);
        if (user != null) {
            entityManager.remove(user);
        }
    }

    @Override
    @Transactional
    public void updateUser(String username, boolean enabled) {
        User user = entityManager.find(User.class, username);
        if (user != null) {
            user.setEnabled(enabled);
            entityManager.merge(user);
        }
    }

    @Override
    @Transactional
    public void updatePassword(String username, String newPassword) {
        User user = entityManager.find(User.class, username);
        if (user != null && newPassword != null && !newPassword.isEmpty()) {
            user.setPassword(passwordEncoder.encode(newPassword));
            entityManager.merge(user);
        }
    }
}
