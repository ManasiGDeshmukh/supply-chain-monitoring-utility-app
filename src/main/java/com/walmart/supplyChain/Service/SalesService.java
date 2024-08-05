package com.walmart.supplyChain.Service;

import com.walmart.supplyChain.Entity.Sales;

import java.util.List;
import java.util.Optional;

public interface SalesService {
    List<Sales> getAllSales();
    Optional<Sales> getSalesById(Long id);
    Sales saveSales(Sales sales);
    void deleteSales(Long id);
}
