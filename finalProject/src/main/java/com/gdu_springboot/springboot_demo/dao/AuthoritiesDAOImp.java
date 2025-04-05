package com.gdu_springboot.springboot_demo.dao;

import com.gdu_springboot.springboot_demo.entity.Authorities;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthoritiesDAOImp implements AuthoritiesDAO {
    private EntityManager em;

    @Autowired
    public AuthoritiesDAOImp(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Authorities> findAll() {
        TypedQuery<Authorities> query = em.createQuery("from Authorities", Authorities.class);
        return query.getResultList();
    }

    @Override
    public List<Authorities> findByUsername(String username) {
        TypedQuery<Authorities> query = em.createQuery("SELECT a FROM Authorities a WHERE a.username = :username", Authorities.class);
        query.setParameter("username", username);
        return query.getResultList(); // Trả về danh sách Authorities
    }

    @Override
    @Transactional
    public Authorities save(Authorities authority) {
        if (authority.getId() == null) {
            em.persist(authority); // Thêm mới
        } else {
            em.merge(authority); // Cập nhật
        }
        return authority;
    }

    @Override
    @Transactional
    public void deleteByUsername(String username) {
        em.createQuery("DELETE FROM Authorities a WHERE a.username = :username")
                .setParameter("username", username)
                .executeUpdate();
    }

    @Override
    @Transactional
    public void deleteByUsernameAndAuthority(String username, String authority) {
        em.createQuery("DELETE FROM Authorities a WHERE a.username = :username AND a.authority = :authority")
                .setParameter("username", username)
                .setParameter("authority", authority)
                .executeUpdate();
    }

    @Override
    @Transactional
    public Authorities findById(Long id) {
        return em.find(Authorities.class, id);  // Tìm kiếm quyền theo id
    }
}
