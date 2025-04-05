package com.gdu_springboot.springboot_demo.service;

import com.gdu_springboot.springboot_demo.dao.AuthoritiesDAO;
import com.gdu_springboot.springboot_demo.entity.Authorities;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthoritiesServiceImp implements AuthoritiesService {

    private AuthoritiesDAO authoritiesDAO;

    @Autowired
    public AuthoritiesServiceImp(AuthoritiesDAO authoritiesDAO) {
        this.authoritiesDAO = authoritiesDAO;
    }

    @Override
    public List<Authorities> findAll() {
        return authoritiesDAO.findAll();
    }

    @Override
    public List<Authorities> findByUsername(String username) {
        return authoritiesDAO.findByUsername(username); // Trả về danh sách authorities
    }

    @Override
    public Authorities save(Authorities authority) {
        return authoritiesDAO.save(authority);
    }

    @Override
    @Transactional
    public void deleteByUsername(String username) {
        authoritiesDAO.deleteByUsername(username);
    }

    @Override
    @Transactional
    public void deleteByUsernameAndAuthority(String username, String authority) {
        authoritiesDAO.deleteByUsernameAndAuthority(username, authority);
    }

    @Override
    public Authorities findById(Long id) {
        return authoritiesDAO.findById(id);  // Gọi findById từ DAO
    }
}
