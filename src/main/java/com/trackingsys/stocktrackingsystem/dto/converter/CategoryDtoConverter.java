package com.trackingsys.stocktrackingsystem.dto.converter;

import com.trackingsys.stocktrackingsystem.dto.CategoryDto;
import com.trackingsys.stocktrackingsystem.entity.Category;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryDtoConverter {

    public CategoryDto convertToDto(Category category){
        return CategoryDto.builder()
                .categoryName(category.getCategoryName())
                .build();
    }

    public List<CategoryDto> convertToDto(List<Category> categories){
        return categories.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}
