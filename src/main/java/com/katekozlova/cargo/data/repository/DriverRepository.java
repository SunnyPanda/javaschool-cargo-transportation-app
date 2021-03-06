package com.katekozlova.cargo.data.repository;

import com.katekozlova.cargo.data.entity.Driver;
import com.katekozlova.cargo.data.entity.DriverStatus;
import com.katekozlova.cargo.data.entity.Truck;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import java.util.List;

@Repository
public class DriverRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Driver> findAll() {
        final TypedQuery<Driver> query = entityManager.createQuery("select d from Driver d", Driver.class);
        return query.getResultList();
    }

    public void delete(Driver driver) {
        entityManager.remove(entityManager.contains(driver) ? driver : entityManager.merge(driver));
    }

    public Driver save(Driver driver) {
        if (driver.getId() == 0) {
            entityManager.persist(driver);
        } else {
            entityManager.merge(driver);
        }
        return driver;
    }

    public List<Driver> findByOrder(long orderId) {
        final TypedQuery<Driver> query = entityManager
                .createQuery("select d from Driver d where d.order.id = :orderId", Driver.class);
        query.setParameter("orderId", orderId);
        return query.getResultList();
    }

    public List<Driver> findByStatus(DriverStatus driverStatus) {
        final TypedQuery<Driver> query = entityManager
                .createQuery("select d from Driver d where d.driverStatus = :driverStatus", Driver.class);
        query.setParameter("driverStatus", driverStatus);
        return query.getResultList();
    }

    public Driver findById(long driverId) {
        final TypedQuery<Driver> query = entityManager
                .createQuery("select d from Driver d where d.id = :driverId", Driver.class);
        query.setParameter("driverId", driverId);
        return query.getSingleResult();
    }

    public List<Driver> findByCurrentTruck(Truck truck) {
        final TypedQuery<Driver> query = entityManager
                .createQuery("select d from Driver d where d.currentTruck = :truck", Driver.class);
        query.setParameter("truck", truck);
        return query.getResultList();
    }

    public List<Driver> findByCurrentTruck(long truckId) {
        final TypedQuery<Driver> query = entityManager
                .createQuery("select d from Driver d where d.currentTruck.id = :truckId", Driver.class);
        query.setParameter("truckId", truckId);
        return query.getResultList();
    }

    public List<Driver> findByOrderAndCurrentCity(long cityId) {
        final TypedQuery<Driver> query = entityManager
                .createQuery("select d from Driver d where d.order is null and d.currentCity.id = :cityId", Driver.class);
        query.setParameter("cityId", cityId);
        return query.getResultList();
    }

    public void updateHoursPerMonth() {
        final CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
        final CriteriaUpdate<Driver> update = cb.createCriteriaUpdate(Driver.class);

        update.from(Driver.class);
        update.set("hoursPerMonth", 0);

        this.entityManager.createQuery(update).executeUpdate();
    }
}
