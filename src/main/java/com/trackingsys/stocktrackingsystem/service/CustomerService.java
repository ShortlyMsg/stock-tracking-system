package com.trackingsys.stocktrackingsystem.service;

import com.trackingsys.stocktrackingsystem.dto.CustomerDto;
import com.trackingsys.stocktrackingsystem.dto.converter.CustomerDtoConverter;
import com.trackingsys.stocktrackingsystem.entity.Customer;
import com.trackingsys.stocktrackingsystem.entity.Order;
import com.trackingsys.stocktrackingsystem.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerDtoConverter customerDtoConverter;

    public CustomerService(CustomerRepository customerRepository, CustomerDtoConverter customerDtoConverter) {
        this.customerRepository = customerRepository;
        this.customerDtoConverter = customerDtoConverter;
    }

    public CustomerDto addCustomer(Customer customer) {
        return customerDtoConverter.convertToDto(customerRepository.save(customer));
    }

    public List<CustomerDto> getAllCustomers() {
        return customerDtoConverter.convertToDto(customerRepository.findAll());
    }

    public CustomerDto getCustomerById(String customerId) {
        return customerDtoConverter.convertToDto(customerRepository.findById(customerId).orElse(null));
    }

    public Customer deleteCustomerById(String customerId) {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        customerRepository.deleteById(customerId);
        return customer;
    }

    public CustomerDto updateCustomerById(Customer customer, String customerId) {
        Customer updateCustomer = customerRepository.findById(customerId).orElse(null);

        updateCustomer.setFirstName(customer.getFirstName());
        updateCustomer.setLastName(customer.getLastName());
        updateCustomer.setBirthDate(customer.getBirthDate());
        updateCustomer.setIdentityNumber(customer.getIdentityNumber());

        return customerDtoConverter.convertToDto(customerRepository.save(updateCustomer));
    }
}
