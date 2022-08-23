package com.trackingsys.stocktrackingsystem.controller;

import com.trackingsys.stocktrackingsystem.dto.OrderDto;
import com.trackingsys.stocktrackingsystem.entity.Order;
import com.trackingsys.stocktrackingsystem.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderDto> addOrder(@RequestBody Order order){
        log.info("Inside addOrder method of OrderController");
        return ResponseEntity.ok(orderService.addOrder(order));
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrders(){
        log.info("Inside getAllOrders method of OrderController");
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable("id") String orderId){
        log.info("Inside getOrderById method of OrderController");
        return ResponseEntity.ok(orderService.getOrderById(orderId));
    }

    @DeleteMapping("/{id}")
    public void deleteOrderById(@PathVariable("id") String orderId){
        log.info("Inside deleteOrderById method of OrderController");
        orderService.deleteOrderById(orderId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDto> updateOrderById(@RequestBody Order order,
                                                     @PathVariable("id") String orderId){
        log.info("Inside updateOrderById method of OrderController");
        return ResponseEntity.ok(orderService.updateOrderById(order, orderId));
    }
}
