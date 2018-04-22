package com.katekozlova.cargo.data.repository;

import com.katekozlova.cargo.data.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public User findByUsername(String username) {
        final TypedQuery<User> query = entityManager
                .createQuery("select u from User u where u.username = :username", User.class);
        query.setParameter("username", username);
        return query.getSingleResult();
    }

}
