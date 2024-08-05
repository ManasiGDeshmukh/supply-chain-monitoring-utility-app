package com.walmart.supplyChain.Service.Impl;

import com.walmart.supplyChain.Entity.Requests;
import com.walmart.supplyChain.Repository.RequestsRepository;
import com.walmart.supplyChain.Service.RequestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestsServiceImpl implements RequestsService {
    @Autowired
    private RequestsRepository requestsRepository;

    public List<Requests> getAllRequests() {
        return requestsRepository.findAll();
    }

    public Optional<Requests> getRequestsById(Long id) {
        return requestsRepository.findById(id);
    }

    public Requests saveRequests(Requests requests) {
        return requestsRepository.save(requests);
    }

    public void deleteRequests(Long id) {
        requestsRepository.deleteById(id);
    }
}
