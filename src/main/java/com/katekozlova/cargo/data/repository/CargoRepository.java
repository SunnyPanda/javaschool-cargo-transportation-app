package com.katekozlova.cargo.data.repository;

import com.katekozlova.cargo.data.entity.Cargo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CargoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Cargo findCargoByNumber(long number) {
        final TypedQuery<Cargo> query = entityManager
                .createQuery("select c from Cargo c where c.number = :number", Cargo.class);
        query.setParameter("number", number);
        return query.getSingleResult();
    }

    public List<Cargo> findAll() {
        final TypedQuery<Cargo> query = entityManager.createQuery("select c from Cargo c", Cargo.class);
        return query.getResultList();
    }
}
