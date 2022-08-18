package com.trackingsys.stocktrackingsystem.service;

import com.trackingsys.stocktrackingsystem.entity.Category;
import com.trackingsys.stocktrackingsystem.entity.Product;
import com.trackingsys.stocktrackingsystem.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category addCategory(Category category) {
        log.info("Inside addCategory method of CategoryService");
        return categoryRepository.save(category);
    }

    public List<Category> getAllCategories() {
        log.info("Inside getAllCategories method of CategoryService");
        return categoryRepository.findAll();
    }

    public Category getProductById(int categoryId) {
        log.info("Inside getProductById method of CategoryService");
        return categoryRepository.findById(categoryId)
                .orElse(null);
    }

    public Category deleteCategoryById(int categoryId) {
        log.info("Inside deleteCategoryById method of CategoryService");
        Category category= categoryRepository.findById(categoryId).orElse(null);
        categoryRepository.deleteById(categoryId);
        return category;
    }

    public Category updateCategoryById(Category category, int categoryId) {
        log.info("Inside updateCategoryById method of CategoryService");
        Category updateCategory = categoryRepository.findById(categoryId).orElse(null);
        updateCategory.setCategoryName(category.getCategoryName());

        return categoryRepository.save(updateCategory);
    }
}
