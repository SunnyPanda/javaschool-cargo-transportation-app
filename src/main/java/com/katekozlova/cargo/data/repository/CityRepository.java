package com.katekozlova.cargo.data.repository;

import com.katekozlova.cargo.data.entity.City;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CityRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<City> findAll() {
        final TypedQuery<City> query = entityManager.createQuery("select c from City c", City.class);
        return query.getResultList();
    }

    public City findById(long cityId) {
        final TypedQuery<City> query = entityManager
                .createQuery("select c from City c where c.id = :cityId", City.class);
        query.setParameter("cityId", cityId);
        return query.getSingleResult();
    }
}
