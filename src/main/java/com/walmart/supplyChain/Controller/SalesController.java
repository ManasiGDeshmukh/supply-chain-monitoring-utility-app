package com.walmart.supplyChain.Controller;

import com.walmart.supplyChain.Entity.Sales;
import com.walmart.supplyChain.Service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sales")
public class SalesController {
    @Autowired
    private SalesService salesService;

    @GetMapping
    public List<Sales> getAllSales() {
        return salesService.getAllSales();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sales> getSalesById(@PathVariable Long id) {
        Optional<Sales> sales = salesService.getSalesById(id);
        return sales.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Sales createSales(@RequestBody Sales sales) {
        return salesService.saveSales(sales);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sales> updateSales(@PathVariable Long id, @RequestBody Sales salesDetails) {
        Optional<Sales> sales = salesService.getSalesById(id);
        if (sales.isPresent()) {
            Sales updatedSales = sales.get();
            updatedSales.setCustID(salesDetails.getCustID());
            updatedSales.setShopManagerID(salesDetails.getShopManagerID());
            updatedSales.setStoreID(salesDetails.getStoreID());
            updatedSales.setProdID(salesDetails.getProdID());
            updatedSales.setCost(salesDetails.getCost());
            return ResponseEntity.ok(salesService.saveSales(updatedSales));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSales(@PathVariable Long id) {
        salesService.deleteSales(id);
        return ResponseEntity.noContent().build();
    }
}