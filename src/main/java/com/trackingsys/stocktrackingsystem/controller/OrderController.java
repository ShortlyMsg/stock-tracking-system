package com.trackingsys.stocktrackingsystem.controller;

import com.trackingsys.stocktrackingsystem.entity.Order;
import com.trackingsys.stocktrackingsystem.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> addOrder(@RequestBody Order order){
        return ResponseEntity.ok(orderService.addOrder(order));
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders(){
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("id") String orderId){
        return ResponseEntity.ok(orderService.getOrderById(orderId));
    }

    @DeleteMapping("/{id}")
    public void deleteOrderById(@PathVariable("id") String orderId){
        orderService.deleteOrderById(orderId);
    }

}
