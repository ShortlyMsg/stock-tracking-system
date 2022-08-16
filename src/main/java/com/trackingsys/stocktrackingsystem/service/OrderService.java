package com.trackingsys.stocktrackingsystem.service;

import com.trackingsys.stocktrackingsystem.entity.Order;
import com.trackingsys.stocktrackingsystem.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(String orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    public Order deleteOrderById(String orderId) {
        Order order = orderRepository.findById(orderId).orElse(null);
        orderRepository.deleteById(orderId);
        return order;
    }
}
