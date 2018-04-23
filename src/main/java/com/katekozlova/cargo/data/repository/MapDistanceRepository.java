package com.katekozlova.cargo.data.repository;

import com.katekozlova.cargo.data.entity.City;
import com.katekozlova.cargo.data.entity.MapDistance;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
public class MapDistanceRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public MapDistance findMapDistanceBetweenTwoCities(City cityFrom, City cityTo) {
        final TypedQuery<MapDistance> query = entityManager
                .createQuery("select md from MapDistance md where (md.cityFrom = :cityFrom and md.cityTo = :cityTo) or " +
                        "(md.cityFrom = :cityTo and md.cityTo = :cityFrom)", MapDistance.class);
        query.setParameter("cityFrom", cityFrom);
        query.setParameter("cityTo", cityTo);

        return query.getSingleResult();
    }
}
