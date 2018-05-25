package com.katekozlova.cargo.data.repository;

import com.katekozlova.cargo.data.entity.BookingStatus;
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

    public Cargo findById(long cargoId) {
        final TypedQuery<Cargo> query = entityManager
                .createQuery("select c from Cargo c where c.id = :cargoId", Cargo.class);
        query.setParameter("cargoId", cargoId);
        return query.getSingleResult();
    }

    public Cargo findByNumber(long number) {
        final TypedQuery<Cargo> query = entityManager
                .createQuery("select c from Cargo c where c.number = :number", Cargo.class);
        query.setParameter("number", number);
        return query.getSingleResult();
    }

    public List<Cargo> findAll() {
        final TypedQuery<Cargo> query = entityManager
                .createQuery("select c from Cargo c", Cargo.class);
        return query.getResultList();
    }

    public Cargo save(Cargo cargo) {
        if (cargo.getId() == 0) {
            entityManager.persist(cargo);
        } else {
            entityManager.merge(cargo);
        }
        return cargo;
    }

    public List<Cargo> findByNullOrder() {
        final TypedQuery<Cargo> query = entityManager
                .createQuery("select c from Cargo c where c.order is null", Cargo.class);
        return query.getResultList();
    }
}
