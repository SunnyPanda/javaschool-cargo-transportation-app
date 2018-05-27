package com.katekozlova.cargo.data.repository;

import com.katekozlova.cargo.data.entity.Order;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class OrderRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Order> findAll() {
        final TypedQuery<Order> query = entityManager.createQuery("select o from Order o", Order.class);
        return query.getResultList();
    }

    public List<Order> findAllOrders() {
        final TypedQuery<Order> query = entityManager.createQuery("select distinct o from Order o left join fetch o.drivers d where d.order = o", Order.class);
        return query.getResultList();
    }

    public Order save(Order order) {
        if (order.getId() == 0) {
            entityManager.persist(order);
        } else {
            entityManager.merge(order);
        }
        return order;
    }

    public Order findById(long orderId) {
        final TypedQuery<Order> query = entityManager
                .createQuery("select o from Order o where o.id = :orderId", Order.class);
        query.setParameter("orderId", orderId);
        return query.getSingleResult();
    }

    public Order findByUniqueNumber(long uniqueNumber) {
        final TypedQuery<Order> query = entityManager
                .createQuery("select o from Order o where o.uniqueNumber = :uniqueNumber", Order.class);
        query.setParameter("uniqueNumber", uniqueNumber);
        return query.getSingleResult();
    }
}
