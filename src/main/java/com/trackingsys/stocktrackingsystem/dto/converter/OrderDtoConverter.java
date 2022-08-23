package com.trackingsys.stocktrackingsystem.dto.converter;

import com.trackingsys.stocktrackingsystem.dto.OrderDto;
import com.trackingsys.stocktrackingsystem.entity.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderDtoConverter {

    public OrderDto convertToDto(Order order){
        return OrderDto.builder()
                .orderNumber(order.getOrderNumber())
                .orderDate(LocalDateTime.now())
                .build();
    }

    public List<OrderDto> convertToDto(List<Order> order){
        return order.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}
