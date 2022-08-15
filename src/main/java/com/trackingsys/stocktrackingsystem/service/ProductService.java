package com.trackingsys.stocktrackingsystem.service;

import com.trackingsys.stocktrackingsystem.entity.Product;
import com.trackingsys.stocktrackingsystem.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(Product product) {
        log.info("Inside addProduct method of ProductService");
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        log.info("Inside getAllProducts method of ProductService");
        return productRepository.findAll();
    }

    public Product getProductById(Long productId) {
        log.info("Inside getProductById method of ProductService");
        return productRepository.findById(productId)
                .orElse(null);
    }

    public Product deleteProductById(Long productId) {
        log.info("Inside deleteProductById method of ProductService");
        Product product = productRepository.findById(productId).orElse(null);
        productRepository.deleteById(productId);
        return product;
    }
}
