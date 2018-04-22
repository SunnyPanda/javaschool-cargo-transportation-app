package com.katekozlova.cargo.data.repository;

import com.katekozlova.cargo.data.entity.Waypoint;
import com.katekozlova.cargo.data.entity.WaypointType;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class WaypointRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Waypoint> findAll() {
        final TypedQuery<Waypoint> query = entityManager.createQuery("select w from Waypoint w", Waypoint.class);
        return query.getResultList();
    }

    //List<Waypoint> findByOrderId(Long orderId);
    public List<Waypoint> findByOrder(long orderId) {
        final TypedQuery<Waypoint> query = entityManager
                .createQuery("select w from Waypoint w where w.order.id = :orderId", Waypoint.class);
        query.setParameter("orderId", orderId);
        return query.getResultList();
    }

    //List<Waypoint> findWaypointsByOrderIsNull();
    public List<Waypoint> findWaypointsByNullOrder() {
        final TypedQuery<Waypoint> query = entityManager
                .createQuery("select w from Waypoint w where w.order is null", Waypoint.class);
        return query.getResultList();
    }

    // Waypoint findWaypointsByCargoIdAndWaypointTypeAndOrderId(long cargoId, WaypointType waypointType, long orderId);
    //Waypoint findWaypointByOrderIdAndCargoIdAndWaypointType(Long orderId, long cargoId, WaypointType waypointType);

    //List<Waypoint> findWaypointsByOrderIdAndWaypointType(long id, WaypointType waypointType);
    public List<Waypoint> findWaypointsByOrderWaypointType(long orderId, WaypointType waypointType) {
        final TypedQuery<Waypoint> query = entityManager
                .createQuery("select w from Waypoint w where w.order.id = :orderId and w.waypointType = :waypointType", Waypoint.class);
        query.setParameter("orderId", orderId);
        query.setParameter("waypointType", waypointType);
        return query.getResultList();
    }
}
