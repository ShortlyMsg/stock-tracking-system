package com.trackingsys.stocktrackingsystem.dto;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderDto {
    private String orderNumber;
    private LocalDateTime orderDate;
}
