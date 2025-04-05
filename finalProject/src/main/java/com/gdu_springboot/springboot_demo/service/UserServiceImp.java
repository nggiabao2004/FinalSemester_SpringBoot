package com.gdu_springboot.springboot_demo.service;

import com.gdu_springboot.springboot_demo.dao.UserDAO;
import com.gdu_springboot.springboot_demo.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    private final UserDAO userDAO;

    @Autowired
    public UserServiceImp(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public User findByUsername(String username) {
        return userDAO.findByUsername(username);
    }

    @Override
    @Transactional
    public User save(User user) {
        return userDAO.save(user);
    }

    @Override
    @Transactional
    public void deleteByUsername(String username) {
        userDAO.deleteByUsername(username);
    }

    @Override
    @Transactional
    public void updateUser(String username, boolean enabled) {
        userDAO.updateUser(username, enabled);
    }

    @Override
    @Transactional
    public void updatePassword(String username, String newPassword) {
        userDAO.updatePassword(username, newPassword);
    }
}
