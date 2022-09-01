package com.trackingsys.stocktrackingsystem.repository;

import com.trackingsys.stocktrackingsystem.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,String> {
}
