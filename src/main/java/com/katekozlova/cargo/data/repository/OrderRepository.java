package com.katekozlova.cargo.data.repository;

import com.katekozlova.cargo.data.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}
