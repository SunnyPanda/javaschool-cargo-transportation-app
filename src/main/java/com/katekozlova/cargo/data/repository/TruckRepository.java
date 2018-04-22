package com.katekozlova.cargo.data.repository;

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

    //List<Truck> findTrucksByTruckStateAndOrderIsNullAndCapacityIsGreaterThan(TruckState truckState, long weight);
    public List<Truck> findByOrderTruckStateCapacity(TruckState truckState, long weight) {
        final TypedQuery<Truck> query = entityManager
                .createQuery("select t from Truck t where t.order is null and t.truckState = :truckState and t.capacity >= :weight", Truck.class);
        query.setParameter("truckState", truckState);
        query.setParameter("weight", weight);
        return query.getResultList();
    }

    //List<Truck> findTrucksByTruckStateAndOrderIsNull(TruckState truckState);

    //Truck findTruckById(Long id);
    public Truck findById(long truckId) {
        final TypedQuery<Truck> query = entityManager
                .createQuery("select t from Truck t where t.id = :truckId", Truck.class);
        query.setParameter("truckId", truckId);
        return query.getSingleResult();
    }
}
