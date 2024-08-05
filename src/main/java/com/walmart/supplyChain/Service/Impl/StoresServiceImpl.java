package com.walmart.supplyChain.Service.Impl;

import com.walmart.supplyChain.Entity.Stores;
import com.walmart.supplyChain.Repository.StoresRepository;
import com.walmart.supplyChain.Service.StoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoresServiceImpl implements StoresService {
    @Autowired
    private StoresRepository storesRepository;

    public List<Stores> getAllStores() {
        return storesRepository.findAll();
    }

    public Optional<Stores> getStoresById(Long id) {
        return storesRepository.findById(id);
    }

    public Stores saveStores(Stores stores) {
        return storesRepository.save(stores);
    }

    public void deleteStores(Long id) {
        storesRepository.deleteById(id);
    }
}
