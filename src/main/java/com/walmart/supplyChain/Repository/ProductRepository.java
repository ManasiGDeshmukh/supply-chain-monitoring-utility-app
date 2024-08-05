package com.walmart.supplyChain.Repository;

import com.walmart.supplyChain.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
