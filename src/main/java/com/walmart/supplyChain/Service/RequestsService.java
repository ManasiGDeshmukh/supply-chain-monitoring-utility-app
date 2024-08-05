package com.walmart.supplyChain.Service;

import com.walmart.supplyChain.Entity.Requests;

import java.util.List;
import java.util.Optional;

public interface RequestsService {
    List<Requests> getAllRequests();
    void deleteRequests(Long id);
    Requests saveRequests(Requests requests);
    Optional<Requests> getRequestsById(Long id);
}
