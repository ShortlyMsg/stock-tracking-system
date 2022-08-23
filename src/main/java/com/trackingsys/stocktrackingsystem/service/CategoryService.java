package com.trackingsys.stocktrackingsystem.service;

import com.trackingsys.stocktrackingsystem.dto.CategoryDto;
import com.trackingsys.stocktrackingsystem.dto.converter.CategoryDtoConverter;
import com.trackingsys.stocktrackingsystem.entity.Category;
import com.trackingsys.stocktrackingsystem.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryDtoConverter categoryDtoConverter;

    public CategoryService(CategoryRepository categoryRepository, CategoryDtoConverter categoryDtoConverter) {
        this.categoryRepository = categoryRepository;
        this.categoryDtoConverter = categoryDtoConverter;
    }

    public CategoryDto addCategory(Category category) {
        log.info("Inside addCategory method of CategoryService");
        return categoryDtoConverter.convertToDto(categoryRepository.save(category));
    }

    public List<CategoryDto> getAllCategories() {
        log.info("Inside getAllCategories method of CategoryService");
        return categoryDtoConverter.convertToDto(categoryRepository.findAll());
    }

    public CategoryDto getProductById(int categoryId) {
        log.info("Inside getProductById method of CategoryService");
        return categoryDtoConverter.convertToDto(categoryRepository.findById(categoryId)
                .orElse(null));
    }

    public Category deleteCategoryById(int categoryId) {
        log.info("Inside deleteCategoryById method of CategoryService");
        Category category= categoryRepository.findById(categoryId).orElse(null);
        categoryRepository.deleteById(categoryId);
        return category;
    }

    public CategoryDto updateCategoryById(Category category, int categoryId) {
        log.info("Inside updateCategoryById method of CategoryService");
        Category updateCategory = categoryRepository.findById(categoryId).orElse(null);
        updateCategory.setCategoryName(category.getCategoryName());

        return categoryDtoConverter.convertToDto(categoryRepository.save(updateCategory));
    }
}
