package com.walmart.supplyChain.Controller;

import com.walmart.supplyChain.Entity.Stores;
import com.walmart.supplyChain.Service.StoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/stores")
public class StoresController {
    @Autowired
    private StoresService storesService;

    @GetMapping
    public List<Stores> getAllStores() {
        return storesService.getAllStores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stores> getStoresById(@PathVariable Long id) {
        Optional<Stores> store = storesService.getStoresById(id);
        return store.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Stores createStores(@RequestBody Stores store) {
        return storesService.saveStores(store);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Stores> updateStores(@PathVariable Long id, @RequestBody Stores storeDetails) {
        Optional<Stores> store = storesService.getStoresById(id);
        if (store.isPresent()) {
            Stores updatedStore = store.get();
            updatedStore.setLocation(storeDetails.getLocation());
            updatedStore.setManagerID(storeDetails.getManagerID());
            return ResponseEntity.ok(storesService.saveStores(updatedStore));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStores(@PathVariable Long id) {
        storesService.deleteStores(id);
        return ResponseEntity.noContent().build();
    }
}
