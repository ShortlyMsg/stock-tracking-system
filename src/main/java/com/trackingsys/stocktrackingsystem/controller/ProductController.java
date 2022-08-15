package com.trackingsys.stocktrackingsystem.controller;

import com.trackingsys.stocktrackingsystem.entity.Product;
import com.trackingsys.stocktrackingsystem.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        log.info("Inside addProduct method of ProductController");
        return ResponseEntity.ok(productService.addProduct(product));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        log.info("Inside getAllProducts method of ProductController");
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long productId){
        log.info("Inside getProductById method of ProductController");
        return ResponseEntity.ok(productService.getProductById(productId));
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable("id") Long productId){
        log.info("Inside deleteProductById method of ProductController");
        productService.deleteProductById(productId);
    }
}
