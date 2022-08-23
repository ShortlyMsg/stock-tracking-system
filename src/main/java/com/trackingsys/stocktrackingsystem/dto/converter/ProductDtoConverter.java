package com.trackingsys.stocktrackingsystem.dto.converter;

import com.trackingsys.stocktrackingsystem.dto.ProductDto;
import com.trackingsys.stocktrackingsystem.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductDtoConverter {

    public ProductDto convertToDto(Product product){
        return ProductDto.builder()
                .productName(product.getProductName())
                .unitStock(product.getUnitStock())
                .unitPrice(product.getUnitPrice())
                .inventory(product.getInventory())
                .stockStatus(product.isStockStatus())
                .build();
    }

    public List<ProductDto> convertToDto(List<Product> products){
        return products.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}
