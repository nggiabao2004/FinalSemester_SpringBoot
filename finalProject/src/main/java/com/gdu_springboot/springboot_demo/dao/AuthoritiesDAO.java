package com.gdu_springboot.springboot_demo.dao;

import com.gdu_springboot.springboot_demo.entity.Authorities;

import java.util.List;

public interface AuthoritiesDAO {
    List<Authorities> findAll();  // Lấy tất cả quyền
    List<Authorities> findByUsername(String username);
    Authorities save(Authorities authority);  // Thêm hoặc cập nhật quyền
    void deleteByUsername(String username);  // Xóa quyền theo username
    void deleteByUsernameAndAuthority(String username, String authority);  // Xóa quyền theo username và authority
    Authorities findById(Long id);
}
