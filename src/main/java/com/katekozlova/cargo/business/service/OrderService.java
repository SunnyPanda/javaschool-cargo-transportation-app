package com.katekozlova.cargo.business.service;

import com.google.common.collect.Lists;
import com.katekozlova.cargo.data.entity.Order;
import com.katekozlova.cargo.data.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return Lists.newArrayList(orderRepository.findAll());
    }
}
