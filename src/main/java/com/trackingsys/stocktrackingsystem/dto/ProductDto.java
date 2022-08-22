package com.trackingsys.stocktrackingsystem.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProductDto {

    private String productName;
    private int unitStock;
    private double unitPrice;
    private String inventory;
    private boolean stockStatus;

}
