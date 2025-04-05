package com.gdu_springboot.springboot_demo.service;

import com.gdu_springboot.springboot_demo.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findByUsername(String username);
    User save(User user);
    void deleteByUsername(String username);
    void updateUser(String username, boolean enabled);
    void updatePassword(String username, String newPassword);
}
