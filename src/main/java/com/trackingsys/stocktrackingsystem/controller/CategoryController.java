package com.trackingsys.stocktrackingsystem.controller;

import com.trackingsys.stocktrackingsystem.entity.Category;
import com.trackingsys.stocktrackingsystem.entity.Product;
import com.trackingsys.stocktrackingsystem.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<Category> addCategory(@RequestBody Category category){
        log.info("Inside addCategory method of CategoryController");
        return ResponseEntity.ok(categoryService.addCategory(category));
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories(){
        log.info("Inside getAllCategories method of CategoryController");
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") int categoryId){
        log.info("Inside getCategoryById method of CategoryController");
        return ResponseEntity.ok(categoryService.getProductById(categoryId));
    }

    @DeleteMapping("/{id}")
    public void deleteCategoryById(@PathVariable("id") int categoryId){
        log.info("Inside deleteCategoryById method of CategoryController");
        categoryService.deleteCategoryById(categoryId);
    }
}
