package com.trackingsys.stocktrackingsystem.dto.converter;

import com.trackingsys.stocktrackingsystem.dto.CustomerDto;
import com.trackingsys.stocktrackingsystem.entity.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerDtoConverter {

    public CustomerDto convertToDto(Customer customer){
        return CustomerDto.builder()
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .birthDate(customer.getBirthDate())
                .identityNumber(customer.getIdentityNumber())
                .build();
    }

    public List<CustomerDto> convertToDto(List<Customer> customers){
        return customers.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}
