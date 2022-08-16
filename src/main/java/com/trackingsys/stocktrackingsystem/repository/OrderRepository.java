package com.trackingsys.stocktrackingsystem.repository;

import com.trackingsys.stocktrackingsystem.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
}
