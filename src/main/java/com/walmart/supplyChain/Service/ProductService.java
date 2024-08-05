package com.walmart.supplyChain.Service;

import com.walmart.supplyChain.Entity.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
}
