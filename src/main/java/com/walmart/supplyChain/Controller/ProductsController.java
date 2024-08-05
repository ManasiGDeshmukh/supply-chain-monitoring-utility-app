package com.walmart.supplyChain.Controller;

import com.walmart.supplyChain.Entity.Product;
import com.walmart.supplyChain.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("products/")
public class ProductsController {
    @Autowired
    ProductService productService;

    @GetMapping(path = "/getProductInfo")
    public List<Product> getAllProductsInfo(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> product = productService.getProductById(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/purchase")
    public ResponseEntity<Product> updateAvailability(@PathVariable Long id) {
        Optional<Product> product = productService.reduceAvailability(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().body(null));
    }
}
