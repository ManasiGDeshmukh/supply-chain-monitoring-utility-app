package com.walmart.supplyChain.Service.Impl;

import com.walmart.supplyChain.Entity.Sales;
import com.walmart.supplyChain.Repository.SalesRepository;
import com.walmart.supplyChain.Service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalesServiceImpl implements SalesService {
    @Autowired
    private SalesRepository salesRepository;

    public List<Sales> getAllSales() {
        return salesRepository.findAll();
    }

    public Optional<Sales> getSalesById(Long id) {
        return salesRepository.findById(id);
    }

    public Sales saveSales(Sales sales) {
        return salesRepository.save(sales);
    }

    public void deleteSales(Long id) {
        salesRepository.deleteById(id);
    }
}
