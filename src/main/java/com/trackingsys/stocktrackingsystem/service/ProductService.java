package com.trackingsys.stocktrackingsystem.service;

import com.trackingsys.stocktrackingsystem.dto.ProductDto;
import com.trackingsys.stocktrackingsystem.dto.converter.ProductDtoConverter;
import com.trackingsys.stocktrackingsystem.entity.Product;
import com.trackingsys.stocktrackingsystem.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductDtoConverter productDtoConverter;

    public ProductService(ProductRepository productRepository, ProductDtoConverter productDtoConverter) {
        this.productRepository = productRepository;
        this.productDtoConverter = productDtoConverter;
    }

    public ProductDto addProduct(Product product) {
        log.info("Inside addProduct method of ProductService");
        return productDtoConverter.convertToDto(productRepository.save(product));
    }

    public List<ProductDto> getAllProducts() {
        log.info("Inside getAllProducts method of ProductService");
        return productDtoConverter.convertToDto(productRepository.findAll());
    }

    public ProductDto getProductById(Long productId) {
        log.info("Inside getProductById method of ProductService");
        return productDtoConverter.convertToDto(productRepository.findById(productId)
                .orElse(null));
    }

    public Product deleteProductById(Long productId) {
        log.info("Inside deleteProductById method of ProductService");
        Product product = productRepository.findById(productId).orElse(null);
        productRepository.deleteById(productId);
        return product;
    }

    public ProductDto updateProductById(Product product, Long productId) {
        log.info("Inside updateProductById method of ProductService");
        Product updateProduct = productRepository.findById(productId).orElse(null);
        updateProduct.setProductName(product.getProductName());
        updateProduct.setUnitStock(product.getUnitStock());
        updateProduct.setUnitPrice(product.getUnitPrice());
        updateProduct.setInventory(product.getInventory());

        return productDtoConverter.convertToDto(productRepository.save(updateProduct));
    }
}
