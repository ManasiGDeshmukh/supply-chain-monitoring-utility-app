package com.walmart.supplyChain.Service.Impl;

import com.walmart.supplyChain.Entity.Product;
import com.walmart.supplyChain.Repository.ProductRepository;
import com.walmart.supplyChain.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Optional<Product> reduceAvailability(Long id) {
        Optional<Product> product = getProductById(id);
        if (product.isPresent()) {
            Product updatedProduct = product.get();
            if (updatedProduct.getAvailability() > 0) {
                updatedProduct.setAvailability(updatedProduct.getAvailability() - 1);
                return Optional.of(productRepository.save(updatedProduct));
            }
        }
        return Optional.empty();
    }
}
