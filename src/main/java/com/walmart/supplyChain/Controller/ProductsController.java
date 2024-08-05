package com.walmart.supplyChain.Controller;

import com.walmart.supplyChain.Entity.Product;
import com.walmart.supplyChain.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
}
