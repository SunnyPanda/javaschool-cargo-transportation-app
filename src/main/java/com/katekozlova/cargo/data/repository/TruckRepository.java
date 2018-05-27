package com.katekozlova.cargo.data.repository;

import com.katekozlova.cargo.data.entity.BookingStatus;
import com.katekozlova.cargo.data.entity.Truck;
import com.katekozlova.cargo.data.entity.TruckState;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class TruckRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Truck> findAll() {
        final TypedQuery<Truck> query = entityManager.createQuery("select t from Truck t", Truck.class);
        return query.getResultList();
    }

    public void delete(Truck truck) {
        entityManager.remove(entityManager.contains(truck) ? truck : entityManager.merge(truck));
    }

    public Truck save(Truck truck) {
        if (truck.getId() == 0) {
            entityManager.persist(truck);
        } else {
            entityManager.merge(truck);
        }
        return truck;
    }

    public Truck findById(long truckId) {
        final TypedQuery<Truck> query = entityManager
                .createQuery("select t from Truck t where t.id = :truckId", Truck.class);
        query.setParameter("truckId", truckId);
        return query.getSingleResult();
    }

    public List<Truck> findByState(TruckState truckState) {
        final TypedQuery<Truck> query = entityManager
                .createQuery("select t from Truck t where t.truckState = :state", Truck.class);
        query.setParameter("state", truckState);
        return query.getResultList();
    }


    public List<Truck> findByOrder() {
        final TypedQuery<Truck> query = entityManager
                .createQuery("select t from Truck t where t.order is not null", Truck.class);
        return query.getResultList();
    }

    public List<Truck> findByOrderTruckState(TruckState truckState) {
        final TypedQuery<Truck> query = entityManager
                .createQuery("select t from Truck t where t.order is null and t.truckState = :state", Truck.class);
        query.setParameter("state", truckState);
        return query.getResultList();
    }

    public List<Truck> findByOrderTruckStateCapacity(TruckState truckState, long weight) {
        final TypedQuery<Truck> query = entityManager
                .createQuery("select t from Truck t where t.order is null " +
                        "and t.truckState = :state and t.capacity >= :weight", Truck.class);
        query.setParameter("state", truckState);
        query.setParameter("weight", weight);
        return query.getResultList();
    }
}
