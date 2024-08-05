package com.walmart.supplyChain.Service.Impl;

import com.walmart.supplyChain.Entity.Product;
import com.walmart.supplyChain.Repository.ProductRepository;
import com.walmart.supplyChain.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
