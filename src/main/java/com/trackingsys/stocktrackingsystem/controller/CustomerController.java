package com.trackingsys.stocktrackingsystem.controller;

import com.trackingsys.stocktrackingsystem.dto.CustomerDto;
import com.trackingsys.stocktrackingsystem.entity.Customer;
import com.trackingsys.stocktrackingsystem.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerDto> addCustomer(@RequestBody Customer customer){
        return ResponseEntity.ok(customerService.addCustomer(customer));
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomers(){
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("id") String customerId){
        return ResponseEntity.ok(customerService.getCustomerById(customerId));
    }

    @DeleteMapping("/{id}")
    public void deleteCustomerById(@PathVariable("id") String customerId){
        customerService.deleteCustomerById(customerId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> updateCustomerById(@RequestBody Customer customer,
                                                    @PathVariable("id") String customerId){
        return ResponseEntity.ok(customerService.updateCustomerById(customer, customerId));
    }
}
