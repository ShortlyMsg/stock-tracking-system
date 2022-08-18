package com.trackingsys.stocktrackingsystem.service;

import com.trackingsys.stocktrackingsystem.entity.Order;
import com.trackingsys.stocktrackingsystem.entity.Product;
import com.trackingsys.stocktrackingsystem.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order addOrder(Order order) {
        log.info("Inside addOrder method of OrderService");
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        log.info("Inside getAllOrders method of OrderService");
        return orderRepository.findAll();
    }

    public Order getOrderById(String orderId) {
        log.info("Inside getOrderById method of OrderService");
        return orderRepository.findById(orderId).orElse(null);
    }

    public Order deleteOrderById(String orderId) {
        log.info("Inside deleteOrderById method of OrderService");
        Order order = orderRepository.findById(orderId).orElse(null);
        orderRepository.deleteById(orderId);
        return order;
    }

    public Order updateOrderById(Order order, String orderId) {
        log.info("Inside updateOrderById method of OrderService");
        Order updateOrder = orderRepository.findById(orderId).orElse(null);
        updateOrder.setOrderNumber(order.getOrderNumber());
        updateOrder.setOrderDate(LocalDateTime.now());

        return orderRepository.save(updateOrder);
    }
}
