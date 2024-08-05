package com.walmart.supplyChain.Service;

import com.walmart.supplyChain.Entity.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProducts();
    Optional<Product> getProductById(Long id);
    Optional<Product> reduceAvailability(Long id);
}
