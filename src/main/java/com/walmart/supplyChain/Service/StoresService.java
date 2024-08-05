package com.walmart.supplyChain.Service;

import com.walmart.supplyChain.Entity.Stores;

import java.util.List;
import java.util.Optional;

public interface StoresService {
    List<Stores> getAllStores();
    Optional<Stores> getStoresById(Long id);
    Stores saveStores(Stores stores);
    void deleteStores(Long id);
}
